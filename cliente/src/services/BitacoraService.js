import axios from 'axios';

let API_URL = 'http://localhost:8080/api/bitacora/';


const obtenerBitacoras = async () => {
   try {
      const response = await axios.get(`${API_URL}`);
      return response.data.data;
   } catch (error) {
      throw error;
   }
};

export {
   obtenerBitacoras
};