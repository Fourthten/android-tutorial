package com.example.movielist.utils

import com.example.movielist.data.ModelData
import com.example.movielist.data.source.remote.response.MovieResponse
import com.example.movielist.data.source.remote.response.TvShowResponse

object DummyData {
    fun generateDataMovieDummyResponse(): List<MovieResponse> {
        val listMovie = ArrayList<MovieResponse>()
        listMovie.add(
            MovieResponse(
                id = 1,
                name = "Yes Day",
                desc = "A mom and dad who usually say no decide to say yes to their kids' wildest requests — with a few ground rules — on a whirlwind day of fun and adventure.",
                poster = "https://upload.wikimedia.org/wikipedia/en/6/60/Yes_Day_film_poster.png",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABWbQJaSviQPfm6EuWi_bjYvqrwgqFKmYYYRyW5nKsrX7pEXl7yedMhhmStsN7BkouNbJIgxNsguSUGjcIE0v4sNenlkO.jpg?r=616"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 2,
                name = "The Willoughbys",
                desc = "Four siblings with horribly selfish parents hatch a plan to get rid of them for good and form a perfectly imperfect family of their own.",
                poster = "https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/The_Willoughbys_Theatrical_release_poster.jpg/220px-The_Willoughbys_Theatrical_release_poster.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABeA7phJqJ5CBdhCMbzSkgB-xpY9HTe2GlglpiDXZpntatXKFY8QBVjyGDS9mV1HN6lcpqkN-qs30fgI8b9sFmzwXTjoi.jpg?r=ae2"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 3,
                name = "Finding 'Ohana",
                desc = "On O'ahu for the summer, two siblings from Brooklyn connect with their Hawaiian heritage — and their family — on a daring quest for long-lost treasure.",
                poster = "https://upload.wikimedia.org/wikipedia/en/3/32/Finding_%27Ohana_%282021%29.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABa5ytNhJHHKE_2Z5-WAqC4ORpzghhiIHUtnaI821uoKkhy_FTNGdWriLXE4P6nraILNntqKH1t3N5Tj1HJiyRLkkqosv.jpg?r=00c"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 4,
                name = "Xico's Journey",
                desc = "A girl, a dog and her best pal set out to save a mountain from a gold-hungry corporation. But the key lies closer to home, with her sidekick pup, Xico.",
                poster = "https://m.media-amazon.com/images/M/MV5BZjUzMTI0NDgtYTdlMC00NTUzLWFkM2ItMThjNzEwZTVhZjhhXkEyXkFqcGdeQXVyMjgzNjA3Mw@@._V1_UY268_CR3,0,182,268_AL_.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABbGja1JmEFjWf9gktq7MJtIEznsORHcgPVe-zmyw_8f_ugNwcRQIN6QSYuRylK9L4ECkCnFu9PUVcBi45uzhu1_oq_A8.jpg?r=c7e"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 5,
                name = "Latte and the Magic Waterstone",
                desc = "When a greedy bear steals a magic stone to keep the forest’s water for himself, a brave hedgehog and a timid squirrel must work together to retrieve it.",
                poster = "https://upload.wikimedia.org/wikipedia/en/thumb/9/96/Latte_and_the_magic_waterstone_ver2_xlg.jpg/220px-Latte_and_the_magic_waterstone_ver2_xlg.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABd4W3liZP-N7OhUacMKsZnUbQnr8tzvUDcVW0jARStzO_kfIFcaoh01nTHQQdGFSTUsM3u7WJvMs9v8Iq1PFnzbYaOXG.jpg?r=158"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 6,
                name = "The SpongeBob Movie: Sponge on the Run",
                desc = "When his best friend Gary is suddenly snatched away, SpongeBob takes Patrick on a madcap mission far beyond Bikini Bottom to save their pink-shelled pal.",
                poster = "https://upload.wikimedia.org/wikipedia/id/thumb/3/34/The_SpongeBob_Movie_-_Sponge_on_the_Run.png/220px-The_SpongeBob_Movie_-_Sponge_on_the_Run.png",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQFkQEYD2t1gRvXOZZBO-16nssNNrPN5AdCMf5jqUnxJX0eazYyXXL2EgkCPqSI4yz6Mu8bB5xX47F8ri5BIgrhkF9Ww.jpg?r=f8c"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 7,
                name = "Jurassic World Camp Cretaceous",
                desc = "Six teens invited to attend a state-of-the-art adventure camp on Isla Nublar must band together to survive when the dinosaurs break out of captivity.",
                poster = "https://static.wikia.nocookie.net/jurassicpark/images/c/cb/JWCC_Discover_the_other_side_of_the_Island.png/revision/latest/scale-to-width-down/310?cb=20200902033706",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABfgP21wirzmUtDnghnCYEbGv2i2EOag_DaTKN2WhgbxPoaDdMXiIhD6TojAZU1yA6nGyro1UOWGTfIif6s__lilydNJt.jpg?r=db1"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 8,
                name = "Kong: King of the Apes",
                desc = "In 2050, an evil scientist is about to unleash an army of robotic dinosaurs. Now it's up to Kong and friends to fight back and save the day.",
                poster = "https://static.wikia.nocookie.net/netflix/images/8/87/Kong_-_King_of_the_Apes.jpg/revision/latest/scale-to-width-down/310?cb=20200625120404",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABaqbFLkvI9mlT0J9vfLLshoQ50wX7dVxKufcqkfjDCKnHvINWDq2jT0JQk3MhEYrFEq5QkYr1ry7CfauZDgChAsdDvUw.jpg?r=346"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 9,
                name = "3Below: Tales of Arcadia",
                desc = "After crash-landing on Earth, two royal teen aliens on the run struggle to blend in with humans as they evade intergalactic bounty hunters.",
                poster = "https://static.wikia.nocookie.net/netflix/images/9/9a/Tales_of_Arcadia.jpg/revision/latest/scale-to-width-down/310?cb=20200527183633",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABb3-2FW76RgBoqBz-1G5AtwINrMrgl7XuoLHpek3Y-M7fdJIgU5DatXxsxF38e2H8L5e9e27tXRwLwVTOkOC3djrOvy1.jpg?r=679"
            )
        )
        listMovie.add(
            MovieResponse(
                id = 10,
                name = "Wakfu",
                desc = "Yugo, a 12-year-old Eliatrope with special powers, sets out on a mission to find his true family and uncover the mysteries of Wakfu.",
                poster = "https://static.wikia.nocookie.net/netflix/images/f/f2/Wakfu.jpg/revision/latest/scale-to-width-down/310?cb=20200715163709",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABVPRv0JZkvNKjTMwXRACrESeE8NV5TJ3rUxTSviLlTK4CC0TLAAOzczhN2JRrwKhe4IwT__RuA_nrzVZF97K6sqF4R8x.jpg?r=325"
            )
        )
        return listMovie
    }

    fun generateDataTvShowDummyResponse(): List<TvShowResponse> {
        val listTvShow = ArrayList<TvShowResponse>()
        listTvShow.add(
            TvShowResponse(
                id = 1,
                name = "Black Clover",
                desc = "Two orphans raised as brothers become rivals as they vie for the title of Wizard King, the highest magical rank in the land.",
                poster = "https://static.wikia.nocookie.net/blackclover/images/6/66/Latest_English_Volume.png/revision/latest/scale-to-width-down/200?cb=20210104174027",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQ4LGNMRSvJnoOWRvtrjhqFVq6VAkOksI-uD-SkrWA3gDHaGU-VcWEPuhflmyV1pCWFptapWWlBAbKRq4Vpn6F3TIdlN.jpg?r=84a"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 2,
                name = "Attack on Titan",
                desc = "With his hometown in ruins, young Eren Yeager becomes determined to fight back against the giant Titans that threaten to destroy the human race.",
                poster = "https://static.wikia.nocookie.net/shingekinokyojin/images/d/db/Volume_1_Cover.png/revision/latest/scale-to-width-down/331?cb=20191030213927",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABd5L51BsUepRIcCGm-BSYeA1YHTUNV5u0g9KTqSrzRcxR2X-rUAV0CA7UHd_07rDDCvVssrFvM7nZ0QQ0nQSz9IlJNv3.jpg?r=d52"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 3,
                name = "Dr. Stone",
                desc = "Awakened into a world where humanity has been petrified, scientific genius Senku and his brawny friend Taiju use their skills to rebuild civilization.",
                poster = "https://static.wikia.nocookie.net/dr-stone/images/c/cb/Anime_date_announcement.png/revision/latest/scale-to-width-down/342?cb=20190110034129",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABVb63C666DEerR8ArvdvnSbfKHNTOwvCtDZeZA95C4KJSVF9uwEA2riFuDcrJqWv4d_PX9_oSTdwKrQR_gByBMV3A6ww.jpg?r=d39"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 4,
                name = "Gin Tama",
                desc = "After Japan's Shogunate is occupied by an alien army, a samurai forced to work as a handyman forms a squad of swordsmen to fight back.",
                poster = "https://static.wikia.nocookie.net/gintama/images/d/d6/Gintamavolume1.jpg/revision/latest/scale-to-width-down/332?cb=20101121234938",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABSJ7fSMFEzI4Hor3bgJbbzhzcfcHnuvkBDCcbik5hNkSMm9EMaA_9MIWX1h5mK2zGpsezZLPK3nHxvipq9M14_CFqiS7.jpg?r=b30"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 5,
                name = "Demon Slayer: Kimetsu no Yaiba",
                desc = "After a demon attack leaves his family slain and his sister cursed, Tanjiro embarks upon a perilous journey to find a cure and avenge those he's lost.",
                poster = "https://static.wikia.nocookie.net/kimetsu-no-yaiba/images/9/9b/Kimetsu_no_Yaiba_-_Official_Character_Book_V3.png/revision/latest/scale-to-width-down/318?cb=20201226050902",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABXUBuD4dxBWS3aYcpXQsErQPCjNKwIsQyYbpo_Ivn3JKv384q64jjwAKlfQL30AmogZu9M9BvjOtJ7bvnxt7i8E9YZZJ.jpg?r=e42"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 6,
                name = "Avatar: The Last Airbender",
                desc = "Siblings Katara and Sokka wake young Aang from a long hibernation and learn he's an Avatar, whose air-bending powers can defeat the evil Fire Nation.",
                poster = "https://static.wikia.nocookie.net/avatar/images/f/fc/Toph_Beifong%27s_Metalbending_Academy.png/revision/latest/scale-to-width-down/250?cb=20200724083349",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQaMNulN0sm14gi4YZLh_q7iLqCyl-oPDcBCSpf5jyLIeofuE3pybhYf-4w_lbZh0Hq8V_di3vc4Asq_S-BgHT0vFnei.jpg?r=fc9"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 7,
                name = "The 100",
                desc = "A century after Earth was devastated by a nuclear apocalypse, 100 space station residents are sent to the planet to determine whether it's habitable.",
                poster = "https://static.wikia.nocookie.net/thehundred/images/8/82/Rebellion_cover.jpg/revision/latest/scale-to-width-down/331?cb=20161017185725",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABajuZxCAQ9a1SeAvCd8VShv-OAyrKg74ywDdCVswsnKHUhwdMpwAXIPltd88n0GxzutReKpyC5iQQFy3Sqj2nScqF6id.jpg?r=556"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 8,
                name = "Love (ft. Marriage and Divorce)",
                desc = "Everything comes unraveling for three successful women who work on a radio show as twists, turns and troubles plague their seemingly happy marriages.",
                poster = "https://upload.wikimedia.org/wikipedia/id/c/c3/Love_%28ft._Marriage_and_Divorce%29.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABRdtj4pWfRMQuYNL-ddADkaCSPKqnsUUbIHUuwiJjlJZYkV_5UEo0KdCVHXcLoOCpaJ_Sp99-Dkwt2JGqqZnF9Bs_hCh.jpg?r=363"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 9,
                name = "Partners for Justice",
                desc = "To pin down criminals and solve cases, a grouchy but brilliant forensic doctor opens up his world to a bright-eyed rookie prosecutor.",
                poster = "https://asianwiki.com/images/7/71/Investigation_Couple-P1.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABd-CxupnCUUKahyE5-s6ipyaKnKupHdXn0Ygj0GM0e8gfBlmClSwVbbj1sNaU4aZm815F9tbwiwnJDcmtzJtpVsl8YIt.jpg?r=e1e"
            )
        )
        listTvShow.add(
            TvShowResponse(
                id = 10,
                name = "Descendants of the Sun",
                desc = "After a chance meeting in a hospital, an ardent soldier falls for a gifted surgeon. Opposing philosophies tear them apart, but fate has other plans.",
                poster = "https://upload.wikimedia.org/wikipedia/id/thumb/6/6e/DescendantsoftheSun.jpg/250px-DescendantsoftheSun.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABdS7P2G0XyVvmLg2VaOsomfb-nDhNTUEeEUTOTMFYnVls95eG-Tc5nVqr8YvobUxchOMgSpH3Rb-QiOl3-yKR-1qyl0J.jpg?r=73c"
            )
        )
        return listTvShow
    }

    fun generateDataMovieDummy(): List<ModelData> {
        val listMovie = ArrayList<ModelData>()
        listMovie.add(
            ModelData(
                id = 1,
                name = "Yes Day",
                desc = "A mom and dad who usually say no decide to say yes to their kids' wildest requests — with a few ground rules — on a whirlwind day of fun and adventure.",
                poster = "https://upload.wikimedia.org/wikipedia/en/6/60/Yes_Day_film_poster.png",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABWbQJaSviQPfm6EuWi_bjYvqrwgqFKmYYYRyW5nKsrX7pEXl7yedMhhmStsN7BkouNbJIgxNsguSUGjcIE0v4sNenlkO.jpg?r=616"
            )
        )
        listMovie.add(
            ModelData(
                id = 2,
                name = "The Willoughbys",
                desc = "Four siblings with horribly selfish parents hatch a plan to get rid of them for good and form a perfectly imperfect family of their own.",
                poster = "https://upload.wikimedia.org/wikipedia/en/thumb/a/a0/The_Willoughbys_Theatrical_release_poster.jpg/220px-The_Willoughbys_Theatrical_release_poster.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABeA7phJqJ5CBdhCMbzSkgB-xpY9HTe2GlglpiDXZpntatXKFY8QBVjyGDS9mV1HN6lcpqkN-qs30fgI8b9sFmzwXTjoi.jpg?r=ae2"
            )
        )
        listMovie.add(
            ModelData(
                id = 3,
                name = "Finding 'Ohana",
                desc = "On O'ahu for the summer, two siblings from Brooklyn connect with their Hawaiian heritage — and their family — on a daring quest for long-lost treasure.",
                poster = "https://upload.wikimedia.org/wikipedia/en/3/32/Finding_%27Ohana_%282021%29.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABa5ytNhJHHKE_2Z5-WAqC4ORpzghhiIHUtnaI821uoKkhy_FTNGdWriLXE4P6nraILNntqKH1t3N5Tj1HJiyRLkkqosv.jpg?r=00c"
            )
        )
        listMovie.add(
            ModelData(
                id = 4,
                name = "Xico's Journey",
                desc = "A girl, a dog and her best pal set out to save a mountain from a gold-hungry corporation. But the key lies closer to home, with her sidekick pup, Xico.",
                poster = "https://m.media-amazon.com/images/M/MV5BZjUzMTI0NDgtYTdlMC00NTUzLWFkM2ItMThjNzEwZTVhZjhhXkEyXkFqcGdeQXVyMjgzNjA3Mw@@._V1_UY268_CR3,0,182,268_AL_.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABbGja1JmEFjWf9gktq7MJtIEznsORHcgPVe-zmyw_8f_ugNwcRQIN6QSYuRylK9L4ECkCnFu9PUVcBi45uzhu1_oq_A8.jpg?r=c7e"
            )
        )
        listMovie.add(
            ModelData(
                id = 5,
                name = "Latte and the Magic Waterstone",
                desc = "When a greedy bear steals a magic stone to keep the forest’s water for himself, a brave hedgehog and a timid squirrel must work together to retrieve it.",
                poster = "https://upload.wikimedia.org/wikipedia/en/thumb/9/96/Latte_and_the_magic_waterstone_ver2_xlg.jpg/220px-Latte_and_the_magic_waterstone_ver2_xlg.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABd4W3liZP-N7OhUacMKsZnUbQnr8tzvUDcVW0jARStzO_kfIFcaoh01nTHQQdGFSTUsM3u7WJvMs9v8Iq1PFnzbYaOXG.jpg?r=158"
            )
        )
        listMovie.add(
            ModelData(
                id = 6,
                name = "The SpongeBob Movie: Sponge on the Run",
                desc = "When his best friend Gary is suddenly snatched away, SpongeBob takes Patrick on a madcap mission far beyond Bikini Bottom to save their pink-shelled pal.",
                poster = "https://upload.wikimedia.org/wikipedia/id/thumb/3/34/The_SpongeBob_Movie_-_Sponge_on_the_Run.png/220px-The_SpongeBob_Movie_-_Sponge_on_the_Run.png",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQFkQEYD2t1gRvXOZZBO-16nssNNrPN5AdCMf5jqUnxJX0eazYyXXL2EgkCPqSI4yz6Mu8bB5xX47F8ri5BIgrhkF9Ww.jpg?r=f8c"
            )
        )
        listMovie.add(
            ModelData(
                id = 7,
                name = "Jurassic World Camp Cretaceous",
                desc = "Six teens invited to attend a state-of-the-art adventure camp on Isla Nublar must band together to survive when the dinosaurs break out of captivity.",
                poster = "https://static.wikia.nocookie.net/jurassicpark/images/c/cb/JWCC_Discover_the_other_side_of_the_Island.png/revision/latest/scale-to-width-down/310?cb=20200902033706",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABfgP21wirzmUtDnghnCYEbGv2i2EOag_DaTKN2WhgbxPoaDdMXiIhD6TojAZU1yA6nGyro1UOWGTfIif6s__lilydNJt.jpg?r=db1"
            )
        )
        listMovie.add(
            ModelData(
                id = 8,
                name = "Kong: King of the Apes",
                desc = "In 2050, an evil scientist is about to unleash an army of robotic dinosaurs. Now it's up to Kong and friends to fight back and save the day.",
                poster = "https://static.wikia.nocookie.net/netflix/images/8/87/Kong_-_King_of_the_Apes.jpg/revision/latest/scale-to-width-down/310?cb=20200625120404",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABaqbFLkvI9mlT0J9vfLLshoQ50wX7dVxKufcqkfjDCKnHvINWDq2jT0JQk3MhEYrFEq5QkYr1ry7CfauZDgChAsdDvUw.jpg?r=346"
            )
        )
        listMovie.add(
            ModelData(
                id = 9,
                name = "3Below: Tales of Arcadia",
                desc = "After crash-landing on Earth, two royal teen aliens on the run struggle to blend in with humans as they evade intergalactic bounty hunters.",
                poster = "https://static.wikia.nocookie.net/netflix/images/9/9a/Tales_of_Arcadia.jpg/revision/latest/scale-to-width-down/310?cb=20200527183633",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABb3-2FW76RgBoqBz-1G5AtwINrMrgl7XuoLHpek3Y-M7fdJIgU5DatXxsxF38e2H8L5e9e27tXRwLwVTOkOC3djrOvy1.jpg?r=679"
            )
        )
        listMovie.add(
            ModelData(
                id = 10,
                name = "Wakfu",
                desc = "Yugo, a 12-year-old Eliatrope with special powers, sets out on a mission to find his true family and uncover the mysteries of Wakfu.",
                poster = "https://static.wikia.nocookie.net/netflix/images/f/f2/Wakfu.jpg/revision/latest/scale-to-width-down/310?cb=20200715163709",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABVPRv0JZkvNKjTMwXRACrESeE8NV5TJ3rUxTSviLlTK4CC0TLAAOzczhN2JRrwKhe4IwT__RuA_nrzVZF97K6sqF4R8x.jpg?r=325"
            )
        )
        return listMovie
    }

    fun generateDataTvShowDummy(): List<ModelData> {
        val listTvShow = ArrayList<ModelData>()
        listTvShow.add(
            ModelData(
                id = 1,
                name = "Black Clover",
                desc = "Two orphans raised as brothers become rivals as they vie for the title of Wizard King, the highest magical rank in the land.",
                poster = "https://static.wikia.nocookie.net/blackclover/images/6/66/Latest_English_Volume.png/revision/latest/scale-to-width-down/200?cb=20210104174027",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQ4LGNMRSvJnoOWRvtrjhqFVq6VAkOksI-uD-SkrWA3gDHaGU-VcWEPuhflmyV1pCWFptapWWlBAbKRq4Vpn6F3TIdlN.jpg?r=84a"
            )
        )
        listTvShow.add(
            ModelData(
                id = 2,
                name = "Attack on Titan",
                desc = "With his hometown in ruins, young Eren Yeager becomes determined to fight back against the giant Titans that threaten to destroy the human race.",
                poster = "https://static.wikia.nocookie.net/shingekinokyojin/images/d/db/Volume_1_Cover.png/revision/latest/scale-to-width-down/331?cb=20191030213927",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABd5L51BsUepRIcCGm-BSYeA1YHTUNV5u0g9KTqSrzRcxR2X-rUAV0CA7UHd_07rDDCvVssrFvM7nZ0QQ0nQSz9IlJNv3.jpg?r=d52"
            )
        )
        listTvShow.add(
            ModelData(
                id = 3,
                name = "Dr. Stone",
                desc = "Awakened into a world where humanity has been petrified, scientific genius Senku and his brawny friend Taiju use their skills to rebuild civilization.",
                poster = "https://static.wikia.nocookie.net/dr-stone/images/c/cb/Anime_date_announcement.png/revision/latest/scale-to-width-down/342?cb=20190110034129",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABVb63C666DEerR8ArvdvnSbfKHNTOwvCtDZeZA95C4KJSVF9uwEA2riFuDcrJqWv4d_PX9_oSTdwKrQR_gByBMV3A6ww.jpg?r=d39"
            )
        )
        listTvShow.add(
            ModelData(
                id = 4,
                name = "Gin Tama",
                desc = "After Japan's Shogunate is occupied by an alien army, a samurai forced to work as a handyman forms a squad of swordsmen to fight back.",
                poster = "https://static.wikia.nocookie.net/gintama/images/d/d6/Gintamavolume1.jpg/revision/latest/scale-to-width-down/332?cb=20101121234938",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABSJ7fSMFEzI4Hor3bgJbbzhzcfcHnuvkBDCcbik5hNkSMm9EMaA_9MIWX1h5mK2zGpsezZLPK3nHxvipq9M14_CFqiS7.jpg?r=b30"
            )
        )
        listTvShow.add(
            ModelData(
                id = 5,
                name = "Demon Slayer: Kimetsu no Yaiba",
                desc = "After a demon attack leaves his family slain and his sister cursed, Tanjiro embarks upon a perilous journey to find a cure and avenge those he's lost.",
                poster = "https://static.wikia.nocookie.net/kimetsu-no-yaiba/images/9/9b/Kimetsu_no_Yaiba_-_Official_Character_Book_V3.png/revision/latest/scale-to-width-down/318?cb=20201226050902",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABXUBuD4dxBWS3aYcpXQsErQPCjNKwIsQyYbpo_Ivn3JKv384q64jjwAKlfQL30AmogZu9M9BvjOtJ7bvnxt7i8E9YZZJ.jpg?r=e42"
            )
        )
        listTvShow.add(
            ModelData(
                id = 6,
                name = "Avatar: The Last Airbender",
                desc = "Siblings Katara and Sokka wake young Aang from a long hibernation and learn he's an Avatar, whose air-bending powers can defeat the evil Fire Nation.",
                poster = "https://static.wikia.nocookie.net/avatar/images/f/fc/Toph_Beifong%27s_Metalbending_Academy.png/revision/latest/scale-to-width-down/250?cb=20200724083349",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABQaMNulN0sm14gi4YZLh_q7iLqCyl-oPDcBCSpf5jyLIeofuE3pybhYf-4w_lbZh0Hq8V_di3vc4Asq_S-BgHT0vFnei.jpg?r=fc9"
            )
        )
        listTvShow.add(
            ModelData(
                id = 7,
                name = "The 100",
                desc = "A century after Earth was devastated by a nuclear apocalypse, 100 space station residents are sent to the planet to determine whether it's habitable.",
                poster = "https://static.wikia.nocookie.net/thehundred/images/8/82/Rebellion_cover.jpg/revision/latest/scale-to-width-down/331?cb=20161017185725",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABajuZxCAQ9a1SeAvCd8VShv-OAyrKg74ywDdCVswsnKHUhwdMpwAXIPltd88n0GxzutReKpyC5iQQFy3Sqj2nScqF6id.jpg?r=556"
            )
        )
        listTvShow.add(
            ModelData(
                id = 8,
                name = "Love (ft. Marriage and Divorce)",
                desc = "Everything comes unraveling for three successful women who work on a radio show as twists, turns and troubles plague their seemingly happy marriages.",
                poster = "https://upload.wikimedia.org/wikipedia/id/c/c3/Love_%28ft._Marriage_and_Divorce%29.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABRdtj4pWfRMQuYNL-ddADkaCSPKqnsUUbIHUuwiJjlJZYkV_5UEo0KdCVHXcLoOCpaJ_Sp99-Dkwt2JGqqZnF9Bs_hCh.jpg?r=363"
            )
        )
        listTvShow.add(
            ModelData(
                id = 9,
                name = "Partners for Justice",
                desc = "To pin down criminals and solve cases, a grouchy but brilliant forensic doctor opens up his world to a bright-eyed rookie prosecutor.",
                poster = "https://asianwiki.com/images/7/71/Investigation_Couple-P1.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/E8vDc_W8CLv7-yMQu8KMEC7Rrr8/AAAABd-CxupnCUUKahyE5-s6ipyaKnKupHdXn0Ygj0GM0e8gfBlmClSwVbbj1sNaU4aZm815F9tbwiwnJDcmtzJtpVsl8YIt.jpg?r=e1e"
            )
        )
        listTvShow.add(
            ModelData(
                id = 10,
                name = "Descendants of the Sun",
                desc = "After a chance meeting in a hospital, an ardent soldier falls for a gifted surgeon. Opposing philosophies tear them apart, but fate has other plans.",
                poster = "https://upload.wikimedia.org/wikipedia/id/thumb/6/6e/DescendantsoftheSun.jpg/250px-DescendantsoftheSun.jpg",
                img_preview = "https://occ-0-64-58.1.nflxso.net/dnm/api/v6/6AYY37jfdO6hpXcMjf9Yu5cnmO0/AAAABdS7P2G0XyVvmLg2VaOsomfb-nDhNTUEeEUTOTMFYnVls95eG-Tc5nVqr8YvobUxchOMgSpH3Rb-QiOl3-yKR-1qyl0J.jpg?r=73c"
            )
        )
        return listTvShow
    }
}