package com.example.online_travel_reservation_.app

class Endpoint {

    private val REGISTER_BASE = "registration.php?"
    private val LOGIN_BASE = "login.php?"
    private val FORGOT_PW = "forgot_pass.php?"
    private val GET_CITY = "city.php?"
    private val GET_ROUTE = "routeinfo.php?"
    private val GET_BUS = "businfo.php?"
    private val GET_SEAT = "seatinfo.php?"
    private val CHOOSE_SEAT = "chooseseat.php?"


    private val FNAME = "firstname"
    private val LNAME = "lastname"
    private val ADDRESS = "address"
    private val EMAIL = "email"
    private val MOBILE = "mobile"
    private val PASSWORD = "password"
    private val ROUTE_STARTPOINT_LATITUDE = "route-startpoint-latitude"
    private val ROUTE_STARTPOINT_LONGITUDE = "route-startpoint-longitude"
    private val ROUTE_ENDPOINT_LATITUDE = "route-endpoint-latitude"
    private val ROUTE_ENDPOINT_LONGITUDE = "route-endpoint-longiude"
    private val ROUTEID = "routeid"
    private val BUSID = "busid"
    private val SEATONE = "seatone"

    fun UserRegister(
        fname: String,
        lname: String,
        address: String,
        password: String,
        email: String,
        mobile: String
    ): String {
        return (Config.BASE_URL + REGISTER_BASE
                + FNAME + "=" + fname + "&"
                + LNAME + "=" + lname + "&"
                + ADDRESS + "=" + address + "&"
                + EMAIL + "=" + email + "&"
                + MOBILE + "=" + mobile + "&"
                + PASSWORD + "=" + password)
    }


    fun Login(
        mobile: String,
        password: String
    ): String {
        return (Config.BASE_URL + LOGIN_BASE
                + MOBILE + "=" + mobile + "&"
                + PASSWORD + "=" + password)
    }

    fun forgot_pw(
        mobile: String
    ): String {
        return (Config.BASE_URL + FORGOT_PW
                + MOBILE + "=" + mobile)
    }

    fun getCity(): String {
        return (Config.BASE_URL + GET_CITY)
    }


    fun getRoute(
        route_startpoint_latitude: String,
        route_startpoint_longitude: String,
        route_endpoint_latitude: String,
        route_endpoint_longiude: String
    ): String {
        return (Config.BASE_URL + GET_ROUTE
                + ROUTE_STARTPOINT_LATITUDE + "=" + route_startpoint_latitude + "&"
                + ROUTE_STARTPOINT_LONGITUDE + "=" + route_startpoint_longitude + "&"
                + ROUTE_ENDPOINT_LATITUDE + "=" + route_endpoint_latitude + "&"
                + ROUTE_ENDPOINT_LONGITUDE + "=" + route_endpoint_longiude)
    }

    fun getBus(routeid: String): String {
        return (Config.BASE_URL + GET_BUS + ROUTEID + "=" + routeid)
    }

    fun getSeat(busid: String): String {
        return (Config.BASE_URL + GET_SEAT + BUSID + "=" + busid)
    }


    fun chooseSingleSeat(busid: String, seatone: String): String {
        return (Config.BASE_URL + CHOOSE_SEAT
                +BUSID + "=" + busid + "&"
                +SEATONE +"=" + seatone)
    }

}