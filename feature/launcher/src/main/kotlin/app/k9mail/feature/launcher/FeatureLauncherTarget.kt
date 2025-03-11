package app.k9mail.feature.launcher

import android.content.Intent
import android.net.Uri
import androidx.core.net.toUri
import app.k9mail.feature.account.edit.navigation.AccountEditRoute
import app.k9mail.feature.account.setup.navigation.AccountSetupRoute
import app.k9mail.feature.funding.api.FundingRoute
import app.k9mail.feature.onboarding.main.navigation.OnboardingRoute

sealed class FeatureLauncherTarget(
    val deepLinkUri: Uri,
    val flags: Int? = null,
) {
    data object Onboarding : FeatureLauncherTarget(
        deepLinkUri = OnboardingRoute.Onboarding().route().toUri(),
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK,
    )

    data object AccountSetup : FeatureLauncherTarget(
        deepLinkUri = AccountSetupRoute.AccountSetup().route().toUri(),
    )

    data class AccountEditIncomingSettings(val accountUuid: String) : FeatureLauncherTarget(
        deepLinkUri = AccountEditRoute.IncomingServerSettings(accountUuid).route().toUri(),
    )

    data class AccountEditOutgoingSettings(val accountUuid: String) : FeatureLauncherTarget(
        deepLinkUri = AccountEditRoute.OutgoingServerSettings(accountUuid).route().toUri(),
    )

    data object Funding : FeatureLauncherTarget(
        deepLinkUri = FundingRoute.Contribution.route().toUri(),
    )
}
