import axios from "axios";

var token = "";
var user = JSON.parse(localStorage.getItem('user'));
if (user && user.token) {
    token = user.token;
}
export default axios.create({
  baseURL: location.protocol + '//' + location.hostname + '/api', // указание адреса сервера
  headers: {
    "Content-Type": "application/json", // обмен данными будем осуществлять в формате json
    "x-access-token":  "Bearer " + token
  }
});