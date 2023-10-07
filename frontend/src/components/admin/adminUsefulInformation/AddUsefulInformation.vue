<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-window-plus"></i>
                        &nbsp;Добавление полезной информации&nbsp;
                        <router-link to="/adminListUsefulInformation" class="btn btn-secondary txt">ВЕРНУТЬСЯ К СПИСКУ СТРАНИЦ С
                            ПОЛЕЗНОЙ ИНФОРМАЦИЕЙ</router-link>
                    </span>
                    <br>
                    <div class="p-3" v-if="!submitted">
                        <form @submit="addInformation">
                            <div class="" style="font-size: 12pt;">
                                <input class="form-check-input" type="checkbox" value="" v-model="checkInformation">
                                &nbsp;Отображать на сайте
                            </div>
                            <div class="mt-2" style="font-size: 12pt;">Название страницы</div>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Название"
                                v-model="information.name" required>
                            <div class="mt-2" style="font-size: 12pt;">Текст страницы</div>
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Текст страницы"
                                rows="15" v-model="information.description" required></textarea>
                            <div class="card mt-3">
                                <div class="top">
                                    <p>Загрузка изображений</p>
                                </div>
                                <div class="drag-area" @dragover.prevent="onDragOver" @dragleave.prevent="onDragLeave"
                                    @drop.prevent="onDrop">
                                    <span v-if="!isDragging">
                                        Перенести сюда или
                                        <span class="select" role="button" @click="selectFiles">
                                            Выбрать
                                        </span>
                                    </span>
                                    <div v-else class="select">Drop images here</div>
                                    <input name="file" type="file" class="file" ref="fileInput" multiple
                                        @change="onFileSelect" />
                                </div>
                                <div class="container">
                                    <div class="image" v-for="(image, index) in images" :key="index">
                                        <span class="delete" @click="deleteImage(index)">&times;</span>
                                        <img :src="image.url" />
                                    </div>
                                </div>
                            </div>
                            <input type="submit" class="btn btn-success mt-2" value="       ДОБАВИТЬ       ">
                        </form>
                    </div>
                    <div class="p-3" v-else>
                        Вы успешно добавили запись!<br>
                        <button v-on:click="newInformation()" class="btn btn-success mt-2" value="ДОБАВИТЬ">ДОБАВИТЬ СТРАНИЦУ</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div v-else>
        {{ $router.push('/') }}
    </div>
</template>
  
<script>
import AdminNavbar from '../AdminNavbar';
import http from "../../../http-common";

export default {
    name: "AddUsefulInformation",
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            checkInformation: "",
            images: [],
            photos: [],
            isDragging: false,
            information: {
                name: "",
                isShow: "",
                date: null,
                description: ""
            },
            submitted: false
        };
    },
    computed: {
        currentUser() {
            return this.$store.state.auth.user;
        }
    },
    methods: {
        selectFiles() {
            this.$refs.fileInput.click();
        },
        onFileSelect(event) {
            const files = event.target.files;
            console.log(files)
            if (files.length === 0) return;
            console.log(this.images)
            for (let i = 0; i < files.length; i++) {
                if(files[i].type.split("/")[0] != "image") continue;
                if(!this.images.some((e) => e.name === files[i].name)){
                    this.photos.push(files[i]);
                    this.images.push({name: files[i].name, url:URL.createObjectURL(files[i]), obj: files[i]});
                }
            }
        },
        deleteImage(index) {
            this.images.splice(index, 1);
            console.log(this.images);
        },
        onDragOver(event) {
            event.preventDefault();
            this.isDragging = true;
            event.dataTransfer.dropEffect = "copy";
        },
        onDragLeave(event) {
            event.preventDefault();
            this.isDragging = false;
        },
        onDrop(event) {
            event.preventDefault();
            this.isDragging = false;
            const files = event.dataTransfer.files;
            for (let i = 0; i < files.length; i++) {
                if (files[i].type.split("/")[0] != "image") continue;
                if (!this.images.some((e) => e.name === files[i].name)) {
                    this.images.push({ name: files[i].name, url: URL.createObjectURL(files[i]) });
                }
            }
        },
        addInformation() {
            if (this.checkInformation === true) {
                this.information.isShow = 1;
            }
            else {
                this.information.isShow = 0;
            }
            let formData = new FormData();
            formData.append('name', this.information.name);
            formData.append('isShow', this.information.isShow);
            formData.append('description', this.information.description);
            for (let i = 0; i < this.images.length; i++) {
                formData.append('files', this.images[i].obj)
            }
            http
                .post("/addInformation", formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then({
                })
                .catch(e => {
                    console.log(e);
                    console.log('AAAAAAAAAAAAAAAAAAAAAAAAAAA');
                });
            // this.submitted = true;
        },
        newInformation() {
            this.submitted = false;
            this.checkInformation = "";
            this.images = [];
            this.photos = [];
            this.isDragging = false;
            this.information.name = "";
            this.information.isShow = "";
            this.information.description = "";
        }
    }
};
</script>
  
<style scoped>
textarea {
    resize: none;
}

.card {
    width: 100%;
    padding: 10px;
    box-shadow: 0 0 5px #ffdfdf;
    border-radius: 5px;
    overflow: hidden;
    background: #c6c6c6;
}

.card .top {
    text-align: center;
}

.card p {
    font-weight: bold;
    color: #434343;
    font-size: 12pt;
}

.card button {
    outline: 0;
    border: 0;
    color: #fff;
    border-radius: 4px;
    font-weight: 400;
    padding: 8px 13px;
    width: 100%;
    background: #434343;
}

.card .drag-area {
    height: 150px;
    border-radius: 5px;
    border: 2px dashed #434343;
    background: #f4f3f9;
    color: #434343;
    display: flex;
    justify-content: center;
    align-items: center;
    user-select: center;
    -webkit-user-select: none;
    margin-top: 10px;
    font-size: 14pt;
}

.card .drag-area .visible {
    font-size: 12pt;
}

.card .select {
    color: #5256ad;
    margin-left: 5px;
    cursor: pointer;
    transition: 0.4s;
}

.card .select:hover {
    opacity: 0.6;
}

.card .container {
    width: 100%;
    height: auto;
    display: flex;
    justify-content: flex-start;
    align-items: flex-start;
    flex-wrap: wrap;
    max-height: 200px;
    position: relative;
    margin-bottom: 8px;
    padding-top: 15px;
}

.card .container .image {
    width: 75px;
    margin-right: 5px;
    height: 75px;
    position: relative;
    margin-bottom: 8px;
}

.card .container .image img {
    width: 100%;
    height: 100%;
    border-radius: 5px;
}

.card .container .image span {
    position: absolute;
    top: -2px;
    right: 9px;
    font-size: 20px;
    cursor: pointer;
}

.card input,
.card .drag-area .on-drop,
.card .drag-area.deagover .visible {
    display: none;
}

.delete {
    z-index: 999;
    color: #fe0000;
}
</style>