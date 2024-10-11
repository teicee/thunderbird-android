package app.k9mail.feature.funding.googleplay.ui.contribution

import app.k9mail.core.ui.compose.testing.ComposeTest
import app.k9mail.core.ui.compose.testing.pressBack
import app.k9mail.core.ui.compose.testing.setContentWithTheme
import app.k9mail.feature.funding.googleplay.ui.contribution.ContributionContract.State
import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test
import kotlinx.coroutines.test.runTest

internal class ContributionScreenKtTest : ComposeTest() {

    @Test
    fun `should observe state and send events to view model`() = runTest {
        val initialState = State()
        val viewModel = FakeContributionViewModel(initialState)
        var onBackCounter = 0

        setContentWithTheme {
            ContributionScreen(
                onBack = { onBackCounter++ },
                viewModel = viewModel,
            )
        }

        assertThat(onBackCounter).isEqualTo(0)

        pressBack()

        assertThat(onBackCounter).isEqualTo(1)
    }
}