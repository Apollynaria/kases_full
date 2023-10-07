<template>
    <div class="contaner-fluid text-center mt-0">
        <div class="zag row">
            <div class="contact-form-container mt-5 mb-5">
                <div class="contact-form">
                    <form @submit="addAppeal">
                        <h3 class="txt">
                            Остались вопросы? Напишите нам
                        </h3>
                        <input class="input-first" placeholder="Ваше имя" id="name" name="name" type="text"
                            v-model="appeal.name" required />
                        <input class="input-first " placeholder="Ваш email " type="email" v-model="appeal.email" required />
                        <textarea placeholder="Сообщение" rows="4" v-model="appeal.message" maxlength="1000"
                            required></textarea>
                        <div id="captcha-container"></div>
                        <div class="d-flex flex-row m-auto mb-2 form-check form-switch">
                            <div style="width: 0pt;">
                                <input type="checkbox" class="form-check-input" id="exampleCheck1"
                                    @click="toggleButtonSend">
                            </div>
                            <div>
                                <label for="exampleCheck1" class="form-check text-left w-100 p-0 mb-3">Соглашаюсь с
                                    политикой
                                    обработки персональных данных</label>
                            </div>
                        </div>
                        <input class="btn btn-danger txt" v-bind:class="{ disabled: isActiveCheckBox }" type="submit" onsubmit="handleSubmit()"
                            value="ОТПРАВИТЬ" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script>
import http from "../http-common";

export default {
    name: 'ContactUs',
    mounted() {
        const script = document.createElement('script');
        script.src = 'https://smartcaptcha.yandexcloud.net/captcha.js?render=onload&onload=onloadFunction';
        script.defer = true;
        document.body.appendChild(script);
        console.log("yes?")
        this.onloadFunction();
    },
    data() {
        return {
            isActiveCheckBox: true,
            appeal: {
                name: null,
                email: null,
                message: null,
                answered: 0
            }
        }
    },
    methods: {
        onloadFunction() {
            if (!window.smartCaptcha) {
                return;
            }

            window.smartCaptcha.render('captcha-container', {
                sitekey: 'ysc1_5JhKuDoAb9WadXPEGhXp613XxO9EODZR1SSCfT8Y804ca09e',
                invisible: true, // Сделать капчу невидимой
                callback: this.callback,
            });
        },

        callback(token) {
            console.log(token);
        },

        handleSubmit() {
            if (!window.smartCaptcha) {
                return;
            }

            window.smartCaptcha.execute();
        },

        addAppeal() {
            var data = {
                name: this.appeal.name,
                email: this.appeal.email,
                message: this.appeal.message,
                answered: 0,
            };
            http
                .post("/addAppeal", data)
                .then(response => {
                    this.appeal.id = response.data.id;
                    console.log(data);
                    this.$router.go();
                })
                .catch(e => {
                    console.log(e);
                });
            this.submitted = true;
        },
        toggleButtonSend() {
            this.isActiveCheckBox = !this.isActiveCheckBox
        }
    }
}
</script>
  
<style scoped>

.form-check-input {
    border: 1.5px solid rgba(68, 68, 68, 0.8);
}

.form-switch .form-check-input:focus {
    border-color: rgba(68, 68, 68, 0.8);
    outline: 0;
    box-shadow: 0 0 0 0 rgba(0, 0, 0, 0);
    background-image: url("data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='-4 -4 8 8'%3e%3ccircle r='3' fill='rgba(0,0,0,0.25)'/></svg>");
}

.form-switch .form-check-input:checked {
    background-color: #a40431ff;
    border-color: #a40431ff;
    background-image: url("data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='-4 -4 8 8'%3e%3ccircle r='3' fill='rgba(255,255,255,1.0)'/></svg>");
}

.btn {
    width: 120pt;
    font-weight: bold;
    font-size: 15pt;
}

.btn:enabled {
    background-color: #a40431ff;
    cursor: pointer;
}

.btn:enabled:hover {
    background-color: #bb2d3b;
}

.btn:enabled:active {
    background-color: #b02a37;
}

.zag {
    background-image: url("../assets/question.jpg");
    background-size: cover;
}

.txt {
    font-family: 'Playfair Display';
}

h3 {
    color: rgba(68, 68, 68, 0.8);
    font-weight: bold;
}

textarea {
    resize: none;
}

.form-check {
    font-size: 14pt;
    color: rgba(68, 68, 68, 0.8);
}

form {
    width: 70%;
    margin: 0 auto;
    padding: 20px;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    background: rgba(255, 255, 255, 1);
}

form input,
form textarea {
    display: block;
    margin: 7px auto;
    width: 100%;
    border: 0;
    font-family: Georgia, serif;
    background-color: rgba(255, 255, 255, 0);
}

.input-first {
    height: 40px;
    line-height: 40px;
    outline: 0;
    border-bottom: 1px solid rgba(68, 68, 68, 0.6);
    font-size: 14pt;
    color: rgba(68, 68, 68, 0.8);
}

form textarea {
    border-bottom: 1px solid rgba(68, 68, 68, 0.6);
    resize: none;
    outline: none;
    font-size: 14pt;
    color: rgba(68, 68, 68, 0.8);
}
</style>