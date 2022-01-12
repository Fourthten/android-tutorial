package com.agungs.githubuserapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agungs.githubuserapp.databinding.FragmentFollowBinding
import com.agungs.githubuserapp.model.Users
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FollowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rvUserFollowGithub: RecyclerView
    private var list: ArrayList<Users> = arrayListOf()
    private lateinit var binding: FragmentFollowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentFollowBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_follow, container, false)
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(index: Int) =
            FollowFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailusers = activity?.intent?.getParcelableExtra<Users>("detailuser")
        val strusername = detailusers?.username
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        var rvUserFollowGithub: RecyclerView = view.findViewById(R.id.rv_userfollowgithub)
        rvUserFollowGithub.setHasFixedSize(true)


        if (index != null) {
            if(index==1) {
                getUserData("https://api.github.com/users/$strusername/followers")
            } else {
                getUserData("https://api.github.com/users/$strusername/following")
            }
        }
    }

    private fun getUserData(urlParams: String) {
//        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = urlParams
        client.addHeader("Authorization", "token a34095d192ec6f637bc5aaace01a4cd0342978e3");
        client.addHeader("User-Agent", "request");
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
//                binding.progressBar.visibility = View.INVISIBLE
                var result = String(responseBody)
                try {
                    var jsonArray = JSONArray(result)
                    list = arrayListOf<Users>()
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val users = Users()
                        users.id = jsonObject.getInt("id")
                        users.username = jsonObject.getString("login")
                        users.followers = jsonObject.getString("followers_url")
                        users.following = jsonObject.getString("following_url")
                        users.type = jsonObject.getString("type")
                        users.avatar = jsonObject.getString("avatar_url")
                        list.add(users)
                    }
                    showUsersRecycleList(list)
                } catch (e: Exception) {
                    Toast.makeText(getActivity()?.getApplicationContext(), e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
//                binding.progressBar.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(getActivity()?.getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showUsersRecycleList(lists :ArrayList<Users>) {
        var rvUserFollowGithub: RecyclerView? = view?.findViewById(R.id.rv_userfollowgithub)
        rvUserFollowGithub?.setHasFixedSize(true)
        rvUserFollowGithub?.layoutManager = LinearLayoutManager(getActivity()?.getApplicationContext())
        val listUsersAdapter = getActivity()?.getApplicationContext()?.let { ListGithubUsers(lists, it) }
        rvUserFollowGithub?.adapter = listUsersAdapter

        listUsersAdapter?.setOnItemClickCallback(object : ListGithubUsers.OnItemClickCallback {
            override fun onItemClicked(data: Users) {
                showSelectedUsers(data)
            }
        })
    }

    private fun showSelectedUsers(users: Users) {
        val moveDetailUsers = Intent(getActivity()?.getApplicationContext(), DetailUsers::class.java)
        moveDetailUsers.putExtra("detailuser", users)
        startActivity(moveDetailUsers)
    }
}