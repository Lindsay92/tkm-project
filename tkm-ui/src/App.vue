<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/shared/Navbar.vue';
import Footer from './components/shared/Footer.vue';
import Toast from "./components/shared/Toast.vue";
</script>

<template>

  <header>
    <RouterView name="navbar"/> 
  </header>

  <div><Toast id="toast-global" /></div>
  
  <main class="container">
    <RouterView />
  </main>

  <footer>
    <Footer></Footer>
  </footer>
  
</template>