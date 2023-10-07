<template>
    <div id="app" class="user_margin">
        <navbar/>
        <div class="contaner-fluid text-center">
            <div class="zag d-flex row">
                <div class="container-fluid h1-00 align-self-center zag-txt">О КОМПАНИИ</div>
            </div>
        </div>
        <div class="container-fluid text-center mt-3" style="width: 95%;">
            <div class="d-flex justify-content-center flex-column flex-sm-column flex-md-column flex-lg-row flex-xl-row" >
                <div class="p-3 text-center">
                    <img class="img-aboutCompany" src="../assets/company1.jpg">
                </div>
                <div class="container-fluid d-flex justify-content-center ">
                    <blockquote class="blockquote-6 align-self-center">
                        <p>Сегодня Иркутский хлебозавод относится к числу немногих предприятий региона, сумевших не только сохранить производство в экстремальных условиях, но и вооружиться новейшими технологиями, гарантирующими и жизнестойкость компании, и стабильное развитие.<br><br>
                            Стратегическая линия развития, взятая 32 года назад мною, как руководителем предприятия, была направлена на коренное перевооружение и формирование коллектива специалистов. И теперь я с гордостью и большим удовлетворением констатирую: обе эти задачи выполнены.<br><br>
                            Иркутский хлебозавод сегодня – это крупное промышленное предприятие с современным оборудованием и сплоченным коллективом профессионалов – «золотым фондом» предприятия.</p>
                        <cite>Каракич Сергей Семенович,<br> Председатель Совета директоров ЗАО «Иркутский хлебозавод»</cite>
                    </blockquote>
                </div>
            </div>
            
            <br>
            <div class="d-flex justify-content-between flex-column flex-sm-column flex-md-column flex-lg-row flex-xl-row" >
                <div class="p-3 text-center">
                    <img class="img-aboutCompany" src="../assets/company2.jpg">
                </div>
                <div class="container-fluid d-flex justify-content-center">
                    <blockquote class="blockquote-6">
                        <p>Есть предприятия, которые занимают особое место не только в экономике, но и в истории нашего города. Без них трудно себе представить нашу жизнь. Кажется, что они были и будут всегда. К таким предприятиям, несомненно, относится Иркутский хлебозавод. 80 лет назад из печей Иркутского хлебозавода вышла первая булка хлеба. С тех пор на нашем хлебе выросло не одно поколение иркутян.<br><br>
                            Новые экономические условия, растущая конкуренция – все это стало толчком к активному развитию и расширению производства. Мы приобретаем новое оборудование, внедряем современные технологии, постоянно обновляем и расширяем ассортимент выпускаемой продукции, радуя сибиряков и гостей нашего региона.<br><br>
                            Сегодня, как и прежде, мы с уверенностью движемся вперед!</p>
                        <cite>Быков Иван Олегович,<br> генеральный директор ЗАО «Иркутский хлебозавод»</cite>
                    </blockquote>
                </div>
            </div>
            <br>
        </div>
        <contactUs />
        <footerBar/>
    </div>
  
  </template>
  
  <script>
      import Navbar from './Navbar';
      import FooterBar from './Footer';
      import ContactUs from './ContactUs';

      export default {
          name: 'AboutCompany',
          components: {
            Navbar: Navbar,
            FooterBar: FooterBar,
            ContactUs: ContactUs,
          }
      }
  </script>
  
  <!--определение стилей-->
  <style scoped>
    .zag{
        height: 200pt;
        font-size: 30pt; 
        font-weight: bold; 
        color: #fff;
        letter-spacing: 0.5pt;
        background-image: url("../assets/zag.jpg");
        background-size:cover;
    }
    
    .img-aboutCompany{
        height: 320pt;
        box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
    }
    .blockquote-6 {
        border-left: 6px solid #d7b369ff;
        font-size: 15pt;
        font-style: italic;
        margin: 3pt;
        padding: 20pt 20pt;
        position: relative;
        align-self: center;
        background: #fff;
        box-shadow: 0 14px 28px rgba(60, 60, 60, 0.25), 0 10px 10px rgba(60, 60, 60, 0.25);
    }
    .blockquote-6:before {
        content: "";
        position: absolute;
        top: 50%;
        left: -6px;
        height: 40px;
        background-color: #fff;
        width: 6px;
        margin-top: -1em;
    }
    .blockquote-6:after {
        content: "”";
        position: absolute;
        top: 49%;
        left: -20px;
        color: #a40431ff;
        font-size: 50px;
        font-family: Times, sans-serif;
        font-weight: bold;
        line-height: 30px;    
    }
    .blockquote-6 cite {
        color: #a40431ff;
        font-size: 15pt;
        font-weight: bold;
        padding-top: 10px;
        display: block;
        text-align: right;
    }
  </style>