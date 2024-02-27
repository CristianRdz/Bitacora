<template>
  <div id="app">
    <div>
      <Navbar />
    </div>

    <div class="app-container">
      <header></header>
      <main>
        <div class="row mt-1">
          <router-view> </router-view>
        </div>
      </main>
      <div></div>
    </div>
  </div>
</template>

<script setup>
import Navbar from "./components/Navbar.vue";
</script>

<style scoped></style>
