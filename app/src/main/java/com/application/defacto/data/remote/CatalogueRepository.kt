package com.application.defacto.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.application.defacto.data.local.entity.law.LawDetailEntity
import com.application.defacto.data.local.entity.law.LawEntity
import com.application.defacto.data.remote.response.law.LawDetailResponse
import com.application.defacto.data.remote.response.law.LawResponse

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    CatalogueDataSource {
    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteData: RemoteDataSource): CatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: CatalogueRepository(remoteData)
            }
    }

    override fun getLaw(): LiveData<List<LawEntity>> {
        val lawData = MutableLiveData<List<LawEntity>>()

        remoteDataSource.getLaws(object : RemoteDataSource.LoadLawCallback {
            override fun onLawLoaded(law: List<LawResponse>?) {
                val lawList = ArrayList<LawEntity>()
                if (law != null) {
                    for (response in law) {
                        with(response) {
                            val laws = LawEntity(
                                id,
                                "Berlaku",
                                nomorPeraturan,
                                judul,
                                tanggalPenetapan)
                            lawList.add(laws)
                        }
                    }
                    lawData.postValue(lawList)
                }
            }
        })
        return lawData
    }

    override fun getDetailLaw(lawId: Int): LiveData<LawDetailEntity> {
        val lawDetailData = MutableLiveData<LawDetailEntity>()

        remoteDataSource.getLawDetail(object : RemoteDataSource.LoadDetailLawCallback {
            override fun onLawDetailLoaded(lawDetail: LawDetailResponse?) {
                if (lawDetail != null) {
                    with(lawDetail) {
                        val detailMovieData = LawDetailEntity(
                                id = id,
                                nomor = nomorPeraturan,
                                judul = judul,
                                jenis = jenisPeraturan,
                                tempat = tempatPenetapan,
                                tanggal_penetapan = tanggalPenetapan,
                                tanggal_pengundangan = tanggalPengundagan,
                                bidang = bidangHukum,
                                bahasa = bahasa,
                                pemrakarsa = pemrakasa,
                                penandatangan = penandatangan,
                                subjek = subjek,
                                simplifikasi = description,
                                pdf = namaFile,
                                status = deletedAt
                        )
                        lawDetailData.postValue(detailMovieData)
                    }
                }
            }
        }, lawId)
        return lawDetailData
    }
}