package com.example.sportfound

object SportHallData {
    private val sportHallName = arrayOf("Kintamani",
        "Jaya Sakti",
        "Mutiara Indah",
        "Pondok Ungu",
        "Cahya Abadi",
        "Gelora Mulia",
        "Yahya",
        "Sukatani",
        "Sunjaya",
        "Soecipto",
        "Mangun Jaya")

    private val sportHallLocation = arrayOf("Jl. Merdeka No. 2 Dago, Coblog, Bandung",
        "Jl. Gatot Subroto No. 289 Sekeloa, Coblog, Bandung",
        "Jl. Sumatera No. 81 Ledeng, Cidadap, Bandung",
        "Jl. Asia Afrika No. 81 Hegarmanah, Cidadap, Bandung",
        "Jl. Cihampelas No. 23 Citarum, Bandung Wetan, Bandung",
        "Jl. Braga No. 67 Wates, Bandung Kidul, Bandung",
        "Jl. Ir. H. Juanda No.18 Kujangsari, Bandung Kidul, Bandung",
        "Jl. Otto Iskandardinata No. 16, Cibuntu, Bandung Kulon, Bandung",
        "Jl. Leumah Neundeut No. 7 Cijerah, Bandung Kulon, Bandung",
        "Jl. Otista No. 16 Cijagra, Lengkong, Bandung",
        "Jl. Ciumbuleuit No. 152 Paledang, Lengkong, Bandung")

    private val sportHallImage = intArrayOf(R.drawable.sporthall1,
        R.drawable.sporthall2,
        R.drawable.sporthall3,
        R.drawable.sporthall4,
        R.drawable.sporthall5,
        R.drawable.sporthall6,
        R.drawable.sporthall7,
        R.drawable.sporthall8,
        R.drawable.sporthall9,
        R.drawable.sporthall10,
        R.drawable.sporthall11)

    private val sportHallTime = arrayOf("09.00 - 21.00",
    "08.00 - 22.00",
    "09.00 - 23.00",
    "09.00 - 22.00",
    "08.30 - 21.00",
    "08.00 - 21.00",
    "08.30 - 21.00",
    "07.30 - 21.00",
    "07.30 - 22.00",
    "07.30 - 23.00",
    "08.00 - 21.30")

    private val sportHallDay = arrayOf("Senin - Jum'at",
        "Senin - Sabtu",
        "Senin - Minggu",
        "Senin - Sabtu",
        "Senin - Minggu",
        "Senin - Sabtu",
        "Senin - Minggu",
        "Senin - Minggu",
        "Senin - Sabtu",
        "Senin - Minggu",
        "Senin - Sabtu")

    val listData: ArrayList<SportHall>
        get() {
            val list = arrayListOf<SportHall>()
            for (position in sportHallName.indices) {
                val sporthall = SportHall()
                sporthall.name = sportHallName[position]
                sporthall.location = sportHallLocation[position]
                sporthall.image = sportHallImage[position]
                sporthall.time = sportHallTime[position]
                sporthall.day = sportHallDay[position]
                list.add(sporthall)
            }
            return list
        }
}