package com.application.defacto.utils

import com.application.defacto.data.local.entity.ArticleEntity
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.local.entity.ProfileEntity

object DataDummy {
    fun getDummyArticle(): List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        articleList.add(ArticleEntity(
            "1",
            "HAK MASYARAKAT DALAM PEMBENTUKAN PERATURAN PERUNDANG-UNDANGAN",
            "-",
            "2000",
            "Jurnal Legislasi Indonesia Vol 17, No 2 Tahun 2020",
            "Hukum Tata Negara",
            "Salahudin Tunjung Seta",
            "-"
        ))

        articleList.add(ArticleEntity(
            "2",
            "Kewenangan Kepala Daerah Dalam Penyelenggaraan Lalu Lintas dan Angkutan Jalan di Provinsi Bengkulu",
            "-",
            "2019",
            "-",
            "-",
            "-",
            "LLAJ"
        ))

        articleList.add(ArticleEntity(
            "3",
            "Artikel Hukum Kabupaten Banyuwangi Nomor Perempuan dan Pendidikan Hukum Tahun perempuan-dan-pendidikan-hukum tentang ",
            "-",
            "perempuan-dan-pendidikan-hukum",
            "-",
            "-",
            "Kabupaten Banyuwangi",
            "-"
        ))

        articleList.add(ArticleEntity(
            "4",
            "APA YANG KAU CARI PANSUS ?",
            "-",
            "2010",
            "KOMPAS; 23-01-2010,;VI/2-5",
            "Hukum Umum",
            "Kabupaten Banyuwangi",
            "BANK DAN PERBANKAN - BANK CENTURY"
        ))

        articleList.add(ArticleEntity(
            "5",
            "IHWAL KRIMINALISASI KEBIJAKAN",
            "-",
            "2010",
            "KOMPAS; 27-01-2010,; VI/2-5",
            "Hukum Umum",
            "Kabupaten Banyuwangi",
            "LEMBAGA NEGARA - BANK CENTURY"
        ))

        return articleList
    }

    fun getDummyUserProfile(): ProfileEntity {
        return ProfileEntity(
                "1",
                "https://static.wikia.nocookie.net/shingekinokyojin/images/b/b1/Levi_Ackermann_%28Anime%29_character_image.png/revision/latest?cb=20210124211652",
                "Muhammad Nur Yusri Maulidin Yusuf",
                "a2782536@bangkit.academy",
                arrayListOf()
            )
    }
}