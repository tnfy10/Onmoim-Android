package com.onmoim.feature.login.state

sealed class LoginEvent {
    data class ShowErrorDialog(val t: Throwable? = null): LoginEvent()
    data object NavigateToHome: LoginEvent()
    data object NavigateToProfileSetting: LoginEvent()
    data object NavigateToInterestSelect: LoginEvent()
}