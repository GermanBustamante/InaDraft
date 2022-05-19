package es.gdebustamante.inadraft.ui.view.preference

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.preference.PreferenceFragmentCompat
import dagger.hilt.android.AndroidEntryPoint
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.ui.GOOGLE_PLAY_ENDPOINT
import es.gdebustamante.inadraft.ui.PREF_OPEN_POLICY
import es.gdebustamante.inadraft.ui.PREF_RATE_APP
import es.gdebustamante.inadraft.ui.SEND_EMAIL_TO_DEV
import es.gdebustamante.inadraft.util.findPreferenceByKey

@AndroidEntryPoint
class AboutAppPreferenceFragment : PreferenceFragmentCompat() {

    companion object {
        fun newInstance() = AboutAppPreferenceFragment()
    }

    //region override methods

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.about_app_preference_fragment, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openPrivacyPolicy()
        rateApplicationInGooglePlay()
        sendEmailToDeveloper()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.about_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.action_app_info -> {
//                activity?.openDetailAppSettings()
//                true
//            }
//            R.id.action_share -> {
//                val marketUri = GOOGLE_PLAY_ENDPOINT + context?.packageName
//                context?.shareLink(
//                    getString(
//                        R.string.share_app_content,
//                        context?.getAppName(),
//                        marketUri
//                    )
//                )
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

    //endregion

    //region private methods

    private fun rateApplicationInGooglePlay() {
        val rateThisApp = findPreferenceByKey(PREF_RATE_APP)
        rateThisApp?.setOnPreferenceClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    GOOGLE_PLAY_ENDPOINT
                            + "com.supercell.clashroyale&gl=ES"//context?.packageName
                )
            )
            startActivity(browserIntent)
            true
        }
    }

    private fun openPrivacyPolicy() {
        val openPolicyDialog = findPreferenceByKey(PREF_OPEN_POLICY)
        openPolicyDialog?.setOnPreferenceClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.privacy_policy_link))
            )
            startActivity(browserIntent)
            true
        }
    }

    private fun sendEmailToDeveloper() {
        val emailToDeveloper = findPreferenceByKey(SEND_EMAIL_TO_DEV)
        emailToDeveloper?.setOnPreferenceClickListener {
            sendReportEmail()
            true
        }
    }

    private fun sendReportEmail() {
        val selectorIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
        }
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            putExtra(
                Intent.EXTRA_EMAIL, arrayOf(
                    getString(R.string.email_contact_summary)
                )
            )
            selector = selectorIntent
        }
        startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }

    //endregion
}