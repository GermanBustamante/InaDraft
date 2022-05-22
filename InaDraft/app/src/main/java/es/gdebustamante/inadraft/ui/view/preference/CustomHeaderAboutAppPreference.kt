package es.gdebustamante.inadraft.ui.view.preference

import android.content.Context
import android.content.pm.PackageManager
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import com.bumptech.glide.Glide
import es.gdebustamante.inadraft.R
import es.gdebustamante.inadraft.ui.EMPTY_STRING
import es.gdebustamante.inadraft.util.getAppName
import es.gdebustamante.inadraft.util.isDarkThemeOn

class CustomHeaderAboutAppPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : Preference(context, attrs, defStyleAttr){

    init {
        widgetLayoutResource = R.layout.preference_about_app_header
    }

    //region override methods

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        holder.apply {
            val mainBackground = findViewById(R.id.aboutAppFragmentImgBackground)
                    as AppCompatImageView
            val appNameLabel = findViewById(R.id.aboutAppFragmentLabelAppName)
                    as TextView
            val appVersionLabel = findViewById(R.id.aboutAppFragmentLabelAppVersion)
                    as TextView
            setHeaderBackgroundWhenIsDarkThemeOn(mainBackground)
            appVersionLabel.text = getVersionName()
            appNameLabel.text = this@CustomHeaderAboutAppPreference.context.getAppName()
        }
    }


    //endregion

    //region private methods

    private fun getVersionName(): String = try {
        val pInfo = context.packageManager.getPackageInfo(
            context.packageName,
            0
        )
        pInfo.versionName

    } catch (e: PackageManager.NameNotFoundException) {
        EMPTY_STRING
    }

    private fun setHeaderBackgroundWhenIsDarkThemeOn(mainBackground: AppCompatImageView) {
        if (this.context.isDarkThemeOn()) {
            Glide.with(this.context)
                .load(R.drawable.bg__ogre_stadium_header_light__about_app)
                .into(mainBackground)

        } else {
            Glide.with(this.context)
                .load(R.drawable.bg__inazuma_stadium_header_light__about_app)
                .into(mainBackground)
        }
    }

}