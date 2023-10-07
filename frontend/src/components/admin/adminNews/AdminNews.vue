<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-clipboard-plus-fill"></i>
                        &nbsp;Новость: {{ this.news.name }}&nbsp;
                        <router-link to="/adminListNews" class="btn btn-secondary">ВЕРНУТЬСЯ К СПИСКУ
                            НОВОСТЕЙ</router-link>
                    </span>
                    <br>
                    <div class="p-3">
                        <!-- <form > @submit="updateNews" -->
                            <form @submit="updateNews">
                            <div class="" style="font-size: 12pt;">
                                <input class="form-check-input" type="checkbox" value="" v-model="checkOneNews">
                                &nbsp;Отображать на сайте
                            </div>
                            <div class="mt-2" style="font-size: 12pt;">Название новости</div>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Название"
                                v-model="news.name" required>
                            <div class="mt-2" style="font-size: 12pt;">Дата новости</div>
                            <DatePicker format="dd/MM/yyyy" class="w-50" placeholder="Дата" value-format="yyyy-MM-dd"
                                locale="ru" v-model="news.date" required />
                            <div class="mt-2" style="font-size: 12pt;">Текст новости</div>
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Текст новости"
                                rows="15" v-model="news.description" required></textarea>
                            <div v-if="news.files.length <= 0 && news.files == null" class="mt-2">
                                <div style="font-size: 12pt;">Файлы не загружены.</div>
                            </div>
                            <div v-else class="row justify-content-center">
                                <div class="p-2 col-sm-12 col-md-6 col-lg-4 col-xl-4 col-xxl-2 col-12 p-3"
                                    v-for="(file, index) in news.files" :key="index">
                                    <img :src="`/api/getFile/${file}`">
                                </div>
                            </div>
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
                            <div class="d-flex justify-content-between">
                                <input v-on:click="updateNews()" class="btn btn-primary mt-3" value="      ИЗМЕНИТЬ      ">
                                <input class="btn btn-danger mt-3" value="УДАЛИТЬ" v-on:click="deleteNews()">
                            </div>
                        </form>
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
    name: "admin-news-details",
    props: ['id'],
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            checkOneNews: "",
            images: [],
            photos: [],
            isDragging: false,
            news: {
                name: "",
                isShow: "",
                description: "",
                date: null,
                files: []
            },
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
            if (files.length === 0) return;
            for (let i = 0; i < files.length; i++) {
                if (files[i].type.split("/")[0] != "image") continue;
                if (!this.images.some((e) => e.name === files[i].name)) {
                    this.photos.push(files[i]);
                    this.images.push({ name: files[i].name, url: URL.createObjectURL(files[i]), fl: files[i] });
                }
            }
        },
        deleteImage(index) {
            this.images.splice(index, 1);
            this.photos.splice(index, 1);
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
                    this.photos.push(files[i]);
                    this.images.push({ name: files[i].name, url: URL.createObjectURL(files[i]), fl: files[i] });
                }
            }
        },
        getNews() {
            http
                .get("/adminNews/" + this.id)
                .then(response => {
                    this.news = response.data;
                    this.checkOneNews = Boolean(this.news.isShow);
                })
                .catch(e => {
                    console.log(e);
                });
        },
        updateNews() {
            if (this.checkOneNews === true) {
                this.news.isShow = 1;
            }
            else {
                this.news.isShow = 0;
            }
            var options = {
                year: 'numeric',
                month: 'numeric',
                day: 'numeric'
            };
            var dateNews = new Date(this.news.date);
            dateNews = dateNews.toLocaleString("ru", options);

            let formData = new FormData();
            formData.append('name', this.news.name);
            formData.append('isShow', this.news.isShow);
            formData.append('description', this.news.description);
            formData.append('date', dateNews);
            
            for (let i = 0; i < this.photos.length; i++) {
                formData.append('files', this.photos[i])
            }      

            http
                .post("/updateNews/" + this.id, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then(() => {
                    this.$router.push('/adminListNews')
                })
                .catch(e => {
                    this.$router.push('/adminListNews')
                    console.log(e);
                });
        },  
        deleteNews() {
            http
                .post("/deleteNews/" + this.id)
                .then(() => {
                    this.$router.push('/adminListNews')
                })
                .catch(e => {
                    this.$router.push('/adminListNews')
                    console.log(e);
                });
        },
    },

    mounted() {
        this.getNews();
    }
};
</script>
  
<style scoped>
img {
    height: 100pt;
}


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

textarea {
    resize: none;
}
</style>