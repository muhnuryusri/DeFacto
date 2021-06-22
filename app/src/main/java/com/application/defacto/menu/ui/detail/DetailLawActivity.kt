package com.application.defacto.menu.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.application.defacto.data.DataHelper.PERATURAN_PEMERINTAH
import com.application.defacto.data.DataHelper.UNDANG_UNDANG
import com.application.defacto.data.local.entity.law.LawDetailEntity
import com.application.defacto.databinding.ActivityDetailLawBinding
import com.application.defacto.utils.FileUtils.getRootDirPath
import com.application.defacto.utils.ViewModelFactory
import com.downloader.Error
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import java.io.File

class DetailLawActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_CATEGORY = "extra_CATEGORY"
    }

    private lateinit var detailLawBinding: ActivityDetailLawBinding
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailLawBinding = ActivityDetailLawBinding.inflate(layoutInflater)
        setContentView(detailLawBinding.root)

        detailLawBinding.pdfViewer.visibility = View.GONE
        detailLawBinding.closeButton.visibility = View.GONE

        detailLawBinding.simplifikasi.visibility = View.GONE

        closePdf()

        val factory = ViewModelFactory.getInstance(this)
        detailViewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getInt(EXTRA_DATA)
            val categoryId = extras.getString(EXTRA_CATEGORY)
            if (categoryId == UNDANG_UNDANG) {
                detailViewModel.getSelectedLaw(dataId).observe(this, { detail ->
                    populateDetailData(detail)
                })
            }   else if (categoryId == PERATURAN_PEMERINTAH) {
                detailViewModel.getSelectedLaw(dataId).observe(this, { detail ->
                    populateDetailData(detail)
                })
            }
        }
    }

    private fun populateDetailData(data: LawDetailEntity) {
        detailLawBinding.tvJudulPeraturan.text = data.judul
        detailLawBinding.tvJenisPeraturan.text = data.jenis
        detailLawBinding.tvNoPeraturan.text = data.nomor.toString()
        detailLawBinding.tvTempatPenetapan.text = data.tempat
        detailLawBinding.tvTglPenetapan.text = data.tanggal_penetapan
        detailLawBinding.tvBidangHukum.text = data.bidang
        detailLawBinding.tvBahasa.text = data.bahasa
        detailLawBinding.tvPemrakarsa.text = data.pemrakarsa
        detailLawBinding.tvPenandatangan.text = data.penandatangan
        detailLawBinding.tvSubjek.text = data.subjek
        detailLawBinding.tvSimplifikasi.text = data.simplifikasi
        detailLawBinding.btnPdf.setOnClickListener {
            Toast.makeText(this@DetailLawActivity, "Downloading...", Toast.LENGTH_SHORT).show()

            val fileName = "myFile.pdf"
            data.pdf?.let {
                downloadPdfFromInternet(
                        it,
                        getRootDirPath(this),
                        fileName
                )
            }
        }
        detailLawBinding.btnSimplifikasi.setOnClickListener {
            detailLawBinding.simplifikasi.visibility = View.VISIBLE
            detailLawBinding.closeButton.visibility = View.VISIBLE
        }
    }

    private fun downloadPdfFromInternet(url: String, dirPath: String, fileName: String) {
        PRDownloader.download(
                url,
                dirPath,
                fileName
        ).build()
                .start(object : OnDownloadListener {
                    override fun onDownloadComplete() {
                        Toast.makeText(this@DetailLawActivity, "Download Complete", Toast.LENGTH_SHORT).show()
                        val downloadedFile = File(dirPath, fileName)
                        showPdfFromFile(downloadedFile)

                        detailLawBinding.pdfViewer.visibility = View.VISIBLE
                        detailLawBinding.closeButton.visibility = View.VISIBLE
                    }

                    override fun onError(error: Error?) {
                        Toast.makeText(this@DetailLawActivity, "Error in downloading file : $error", Toast.LENGTH_LONG).show()
                    }
                })
    }

    private fun showPdfFromFile(file: File) {
        detailLawBinding.pdfViewer.fromFile(file)
                .password(null)
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .onPageError { page, _ ->
                    Toast.makeText(
                            this@DetailLawActivity,
                            "Error at page: $page", Toast.LENGTH_LONG
                    ).show()
                }
                .load()
    }

    private fun closePdf() {
        detailLawBinding.closeButton.setOnClickListener {
            detailLawBinding.pdfViewer.visibility = View.GONE
            detailLawBinding.closeButton.visibility = View.GONE
            detailLawBinding.simplifikasi.visibility = View.GONE
        }
    }
}