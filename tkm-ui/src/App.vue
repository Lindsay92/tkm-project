<script setup>
import { RouterView } from 'vue-router'
import Navbar from './components/shared/Navbar.vue';
import Footer from './components/shared/Footer.vue';
</script>

<template>
  <header>
    <Navbar/>
  </header>

  <main class="container">
    <RouterView />
  </main>

  <footer>
    <Footer></Footer>
  </footer>

</template>