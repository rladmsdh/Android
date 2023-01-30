package data.model

data class LoginResponse(
    val access_token : String,
    val refresh_token : String,
)

data class LoginRequest(
    val account_id : String,
    val password : String,
)