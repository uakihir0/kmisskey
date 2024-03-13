package work.socialhub.kmisskey.entity

import kotlinx.serialization.Serializable

@Serializable
open class Meta {

    var maintainerName: String? = null
    var maintainerEmail: String? = null
    var version: String? = null
    var name: String? = null
    var uri: String? = null
    var description: String? = null
    var langs: List<String>? = null
    var tosUrl: String? = null
    var repositoryUrl: String? = null
    var feedbackUrl: String? = null
    var defaultDarkTheme: String? = null
    var defaultLightTheme: String? = null
    var disableRegistration: Boolean? = null
    var cacheRemoteFiles: Boolean? = null
    var emailRequiredForSignup: Boolean? = null
    var enableHcaptcha: Boolean? = null
    var hcaptchaSiteKey: String? = null
    var enableRecaptcha: Boolean? = null
    var recaptchaSiteKey: String? = null
    var enableTurnstile: Boolean? = null
    var turnstileSiteKey: String? = null
    var swPublickey: String? = null
    var mascotImageUrl: String? = null
    var bannerUrl: String? = null
    var errorImageUrl: String? = null
    var iconUrl: String? = null
    var maxNoteTextLength: Long? = null

    var requireSetup: Boolean? = null
    var enableEmail: Boolean? = null
    var enableServiceWorker: Boolean? = null
    var translatorAvailable: Boolean? = null
    var proxyAccountName: String? = null
    var policies: Policies? = null
    var mediaProxy: String? = null
    var features: MetaFeatures? = null

    /**
     * available up to v12
     * use /emojis endpoint.
     */
    @Deprecated("use /emojis endpoint.")
    var emojis: List<Emoji>? = null
}
