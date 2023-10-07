<template>
  <div id="app" class="m-0">
    <router-view />
  </div>
  <!-- <div class="SmartCaptcha-Overlay" data-testid="advanced-container" tabindex="-1" style="--smart-captcha-doc-height: 715px; --smart-captcha-doc-width: 982px;"><div class="SmartCaptcha-Spin"></div><iframe frameborder="0" src="https://smartcaptcha.yandexcloud.net/advanced.ru.1955e35a506996e56bfb.html?sitekey=ysc1_5JhKuDoAb9WadXPEGhXp613XxO9EODZR1SSCfT8Y804ca09e&amp;hl=ru&amp;host=localhost:4200&amp;test=false&amp;webview=false&amp;hideChallengeContainer=false" aria-hidden="true" style="display: block; width: 100%; height: 100%; z-index: 0; transform: translate3d(0px, 0px, 0px);" data-testid="advanced-iframe" title="SmartCaptcha advanced widget" tabindex="-1"></iframe></div> -->
  <!-- <div class="SmartCaptcha-Shield SmartCaptcha-Shield_position_bottom SmartCaptcha-Shield_position_right" data-testid="shield">
    <a class="SmartCaptcha-Shield-Anchor" href="https://cloud.yandex.ru/services/smartcaptcha" target="_blank" data-testid="shield-open-button">
      <svg width="20" height="20" viewBox="0 0 20 20" fill="none">
        <path fill-rule="evenodd" clip-rule="evenodd" d="M18.2333 10C18.2333 14.55 14.55 18.2333 10 18.2333C8.8094 18.2333 7.92021 17.7864 7.47551 17.2443C7.03081 16.7022 6.90571 15.8152 7.0588 14.5339L9.70884 14.0082C12.13 13.5647 13.4641 12.2176 13.9417 9.80288C14.0001 9.46485 14.0669 9.12682 14.1301 8.8064C14.156 8.67525 14.1813 8.54705 14.2052 8.42301C14.2774 8.03104 14.3471 7.65855 14.411 7.31691C14.4783 6.95699 14.5392 6.63132 14.5899 6.3532C14.861 4.78329 14.6407 3.62423 14.0309 2.81788C16.5398 4.22801 18.2333 6.91477 18.2333 10ZM10 1.76667C5.45 1.76667 1.76667 5.45 1.76667 10C1.76667 13.0852 3.4602 15.772 5.96913 17.1821C5.35934 16.3758 5.13899 15.2167 5.4101 13.6468C5.46835 13.3273 5.53804 12.9507 5.6158 12.5305C5.66997 12.2378 5.72806 11.9239 5.78892 11.5934C5.81284 11.4694 5.83814 11.3412 5.86403 11.21C5.92728 10.8896 5.99401 10.5516 6.05244 10.2136C6.51361 7.78235 7.8477 6.43534 10.2688 5.99181L12.9412 5.46614C13.0943 4.18484 12.9692 3.29778 12.5245 2.75569C12.0798 2.2136 11.1906 1.76667 10 1.76667ZM20 10C20 15.5167 15.5167 20 10 20C4.48333 20 0 15.5167 0 10C0 4.48333 4.48333 0 10 0C15.5167 0 20 4.48333 20 10ZM12.6241 7.30597L10.6147 7.70022C8.9018 8.02876 8.11123 8.81726 7.78182 10.5257C7.70523 10.9076 7.63854 11.2698 7.57407 11.6199C7.55536 11.7215 7.53682 11.8222 7.5183 11.922C7.46888 12.1848 7.41947 12.4476 7.37006 12.694L9.36297 12.2998C11.0759 11.9712 11.883 11.1827 12.2124 9.47434C12.2848 9.11359 12.3515 8.75192 12.4182 8.39024C12.485 8.02852 12.5517 7.6668 12.6241 7.30597Z" fill="black" fill-opacity="0.85"></path>
      </svg>
    </a>
    <a href="https://yandex.ru/legal/smartcaptcha_notice" class="SmartCaptcha-Shield-PrivacyLink" target="_blank" tabindex="-1" aria-hidden="true">
      Политика обработки данных
    </a>
    <button class="SmartCaptcha-Shield-CloseButton" aria-label="Close Shield" data-testid="shield-close-button" tabindex="-1" aria-hidden="true">
        <svg width="8" height="8" viewBox="0 0 8 8" fill="none">
          <path fill-rule="evenodd" clip-rule="evenodd" d="M7.80474 6.86193C8.06509 7.12228 8.06509 7.54439 7.80474 7.80474C7.54439 8.06509 7.12228 8.06509 6.86193 7.80474L4 4.94281L1.13807 7.80474C0.877722 8.06509 0.455612 8.06509 0.195262 7.80474C-0.0650874 7.54439 -0.0650874 7.12228 0.195262 6.86193L3.05719 4L0.195262 1.13807C-0.0650874 0.877722 -0.0650874 0.455612 0.195262 0.195262C0.455612 -0.0650874 0.877722 -0.0650874 1.13807 0.195262L4 3.05719L6.86193 0.195262C7.12228 -0.0650874 7.54439 -0.0650874 7.80474 0.195262C8.06509 0.455612 8.06509 0.877722 7.80474 1.13807L4.94281 4L7.80474 6.86193Z" fill="black" fill-opacity="0.85"></path>
        </svg>
    </button>
    </div> -->
</template>

<script>
export default {
  name: 'App',
  components: {
  }
}
</script>

<!--определение стилей-->
<style>
@import url('https://fonts.googleapis.com/css?family=Playfair+Display');
/* @import url('https://fonts.googleapis.com/css?family=Prata');
@import url('https://fonts.googleapis.com/css?family=Forum'); */

html, body {
  height: 100%;
}

#app {
  /* height: 100%; */
  font-family: Georgia, serif;
    /* font-family: 'Playfair Display'; */
    /* font-family: 'Prata'; */
    /* font-family: 'Forum'; */
    font-weight: 400;
    position: relative;
    background: #f7f1eb;
  }
</style>