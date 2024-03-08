<template>
  <div>
    <b-navbar type="dark" variant="dark">
      <div class="mb-2">
        <b-avatar
          src="https://indiehoy.com/wp-content/uploads/2020/12/shrek.jpg"
        ></b-avatar>
      </div>
      <b-navbar-nav>
        <b-nav-item href="#">Home</b-nav-item>

        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">ES</b-dropdown-item>
          <b-dropdown-item href="#">RU</b-dropdown-item>
          <b-dropdown-item href="#">FA</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="User" right>
          <b-dropdown-item href="#">Account</b-dropdown-item>
          <b-dropdown-item href="#">Settings</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-button v-b-modal.modal-1>Bitacora de Cambios</b-button>
      </b-navbar-nav>
    </b-navbar>
    
  <b-modal id="modal-1" title="BootstrapVue">
    <b-table striped hover :items="items"></b-table>
  </b-modal>
  </div>
</template>

<script>
import {obtenerBitacoras} from '../services/BitacoraService';
  export default {
    data() {
      return {
        items: []
      }
    },
    methods:{
      async getData() {
      try {
        
        this.items = await obtenerBitacoras();
      } catch (error) {
        console.error(error);
        alert(
          "Ocurrió un error al obtener la bitacora chance no hay conexión a internet"
        );
      }
    },
    },
    async mounted() {
        await this.getData();
    },
  }
</script>

<style scoped>
</style>
