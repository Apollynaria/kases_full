<template>
    <div id="app" class="user_margin">
        <navbar />
        <div class="contaner-fluid text-center row">
            <span class="align-self-center">Упс.. Страница не найдена (404)</span>
            <br>
        </div>
        <footerBar />
    </div>
</template>
  
<script>
import Navbar from './Navbar';
import FooterBar from './Footer';

export default {
    name: 'NotFound',
    components: {
        Navbar: Navbar,
        FooterBar: FooterBar,
    }
}
</script>
  
  <!--определение стилей-->
<style scoped>
span {
    font-family: 'Playfair Display';
    font-weight: bold;
    font-size: 20pt;
}

.contaner-fluid {
    height: 30vw;
}
</style>