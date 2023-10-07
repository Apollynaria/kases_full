import http from "../http-common";

function login(user) {
    var data = {
        login: user.login,
        password: user.password
    };
    return http
        .post("/auth/signin", data)
        .then(response => {
            console.log(response);
            if (response.data.token) {
                localStorage.setItem('user', JSON.stringify(response.data)); 
            }
            return response.data;
        });
}

function logout() {
    localStorage.removeItem('user'); 
}


function refreshToken(user) {
    var data = {
        username: user.username
    };
    return http
        .post("/refreshToken", data)
        .then(response => {
            if (response.data.accessToken) {
                localStorage.setItem('user', JSON.stringify(response.data));// записываем данные пользователя в локальное хранилище, которое хранится в браузере
            }
            return response.data;
        });
}

function jwtDecrypt(token) {
    var base64Url = token.split(".")[1];
    var base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
    var jsonPayload = decodeURIComponent(
        window.atob(base64)
            .split("")
            .map((c) => {
                return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
            })
            .join("")
    );
    return JSON.parse(jsonPayload);
}

function tokenAlive(exp) {
    if (Date.now() >= exp * 1000) {
        return false;
    }
    return true;
}

export default {
    login: login,
    logout: logout,
    refreshToken: refreshToken,
    jwtDecrypt: jwtDecrypt,
    tokenAlive: tokenAlive
};