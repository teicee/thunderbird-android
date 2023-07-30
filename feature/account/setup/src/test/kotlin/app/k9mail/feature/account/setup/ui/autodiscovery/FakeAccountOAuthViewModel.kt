package app.k9mail.feature.account.setup.ui.autodiscovery

import app.k9mail.core.ui.compose.common.mvi.BaseViewModel
import app.k9mail.feature.account.oauth.ui.AccountOAuthContract
import app.k9mail.feature.account.oauth.ui.AccountOAuthContract.Effect
import app.k9mail.feature.account.oauth.ui.AccountOAuthContract.Event
import app.k9mail.feature.account.oauth.ui.AccountOAuthContract.State

internal class FakeAccountOAuthViewModel(
    initialState: State = State(),
) : BaseViewModel<State, Event, Effect>(initialState), AccountOAuthContract.ViewModel {

    val events = mutableListOf<Event>()

    override fun initState(state: State) {
        updateState { state }
    }

    override fun event(event: Event) {
        events.add(event)
    }

    fun effect(effect: Effect) {
        emitEffect(effect)
    }
}
