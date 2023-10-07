<template>
    <div v-if="currentUser" class="container-fluid mb-5 w-100 g-0 ">
        <div class="d-flex flex-row " style="background: #eeeeee;">
            <AdminNavbar />
            <div class="p-0 w-100 content" style="background: #fff;">
                <div class="catalog-menu-headings position-relative mt-2">
                    <span class="p-3">
                        <i class="bi bi-cart-plus-fill"></i>
                        &nbsp;Добавление продукта
                        <router-link to="/adminListProducts" class="btn btn-secondary txt">ВЕРНУТЬСЯ К СПИСКУ
                            ВСЕХ ПРОДУКТОВ</router-link>
                    </span>
                    <br>
                    <div class="p-3" v-if="!submitted">
                        <form @submit="addProduct">
                            <div style="font-size: 12pt;">
                                <input class="form-check-input" type="checkbox" value="" v-model="checkProduct">
                                &nbsp;Отображать на сайте
                            </div>
                            <div style="font-size: 12pt;" class="mt-2">Название</div>
                            <input type="text" name="name" class="form-control" id="name" placeholder="Название"
                                v-model="product.name" required>
                            <div class="mt-2">
                                <div style="font-size: 12pt;">Категория продукта</div>

                                <select class="form-control" id="typeProduct" v-model="product.productTypeId" required>
                                    <option value="" selected disabled hidden>Категория продукта</option>
                                    <option v-for="(type, index) in types" :key="index" :value="type.id">
                                        {{ type.name }}
                                    </option>
                                </select>
                            </div>
                            <div class="mt-2" style="font-size: 12pt;">Описание</div>
                            <textarea class="form-control" id="exampleFormControlTextarea1" placeholder="Описание" rows="5"
                                v-model="product.description" required></textarea>
                            <div class="mt-2" style="font-size: 12pt;">Масса</div>
                            <input step="0.1" type="number" name="weight" class="form-control w-50" min="0" id="weight"
                                placeholder="Масса (грамм)" v-model="product.weight" required>
                            <div class="mt-2" style="font-size: 12pt;">Калорийность</div>
                            <input input step="0.1" type="number" name="calories" min="0" class="form-control w-50"
                                id="calories" placeholder="Калорийность" v-model="product.calories" required>
                            <div class="mt-2" style="font-size: 12pt;">Белки</div>
                            <input input step="0.1" type="number" name="protein" min="0" class="form-control w-50"
                                id="protein" placeholder="Белки" v-model="product.protein" required>
                            <div class="mt-2" style="font-size: 12pt;">Жиры</div>
                            <input input step="0.1" type="number" name="fats" min="0" class="form-control w-50" id="fats"
                                placeholder="Жиры" v-model="product.fats" required>
                            <div class="mt-2" style="font-size: 12pt;">Углеводы</div>
                            <input input step="0.1" type="number" name="carbohydrates" min="0" class="form-control w-50"
                                id="carbohydrates" placeholder="Углеводы" v-model="product.carbohydrates" required>
                            <div class="mt-2" style="font-size: 12pt;">Срок хранения</div>
                            <input type="text" name="shelfLife" class="form-control w-50" id="shelfLife"
                                placeholder="Срок хранения" v-model="product.shelf_life" required>
                            <div class="mt-2" style="font-size: 12pt;">Код</div>
                            <input type="number" name="code" class="form-control w-50" id="code"
                                placeholder="Код продукта" v-model="product.code" required>
                            <div class="mt-2">
                                <div style="font-size: 12pt;">Фотография продукта (форматы: jpg, png)</div>
                                <input type="file" id="file" name="file" ref="file" v-on:change="handleFileUpload()"
                                    class="form-control w-50" accept=".jpg, .png" />
                            </div>

                            <input type="submit" class="btn btn-success mt-2" value="       ДОБАВИТЬ       ">
                        </form>
                    </div>
                    <div class="p-3" v-else>
                        Вы успешно добавили запись!<br>
                        <button v-on:click="newProduct()" class="btn btn-success mt-2" value="ДОБАВИТЬ">ДОБАВИТЬ ПРОДУКТ</button>
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
    name: "AddProduct",
    components: {
        AdminNavbar: AdminNavbar,
    },
    data() {
        return {
            checkProduct: "",
            types: [],
            product: {
                name: "",
                isShow: "",
                productTypeId: "",
                description: "",
                weight: 0,
                calories: 0,
                protein: 0,
                fats: 0,
                carbohydrates: 0,
                shelf_life: "",
                code: "",
                photo: ""
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
        getTypes() {
            http
                .get("/listProductTypes")
                .then(response => {
                    this.types = response.data;
                })
                .catch(e => {
                    console.log(e);
                });
        },
        addProduct(e) {
            console.log(this.checkProduct);
            if (this.checkProduct === true) {
                this.product.isShow = 1;
            }
            else {
                this.product.isShow = 0;
            }
            console.log(e);
            let formData = new FormData();
            formData.append('name', this.product.name);
            formData.append('isShow', this.product.isShow);
            formData.append('productTypeId', this.product.productTypeId);
            // formData.append('fileIsUpload', this.fileIsUpload);
            formData.append('description', this.product.description);
            formData.append('weight', this.product.weight);
            formData.append('calories', this.product.calories);
            formData.append('protein', this.product.protein);
            formData.append('fats', this.product.fats);
            formData.append('carbohydrates', this.product.carbohydrates);
            formData.append('shelf_life', this.product.shelf_life);
            formData.append('code', this.product.code);
            formData.append('photo', this.product.photo);
            console.log(this.product.productTypeId);
            http
                .post("/addProduct", formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .then({
                })
                .catch(e => {
                    console.log(e);
                });
            this.fileIsUpload = 0;
            this.submitted = true;
        },
        newProduct() {
            this.submitted = false;
            this.product = {
                name: "",
                isShow: "",
                productTypeId: "",
                description: "",
                weight: 0,
                calories: 0,
                protein: 0,
                fats: 0,
                carbohydrates: 0,
                shelf_life: "",
                code: "",
                photo: ""
            };
        },
        handleFileUpload() {
            this.fileIsUpload = 1;
            this.product.photo = this.$refs.file.files[0];
        }
    },
    mounted() {
        this.getTypes();
    },
};
</script>
  
<style scoped>
textarea {
    resize: none;
}
</style>