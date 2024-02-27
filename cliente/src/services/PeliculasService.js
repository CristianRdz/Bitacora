import axios from 'axios';

let API_URL = 'http://localhost:8080/api/peliculas';


const obtenerPeliculas = async () => {
   try {
      const response = await axios.get(`${API_URL}`);
      return response.data.data;
   } catch (error) {
      throw error;
   }
};

const savePelicula = async (pelicula) => {
    try {
        const response = await axios.post(`${API_URL}`, pelicula);
        return response.data;
    } catch (error) {
        throw error;
    }
    }
    const updatePelicula = async (pelicula) => {
        try {
            const response = await axios.put(`${API_URL}`, pelicula);
            return response.data;
        } catch (error) {
            throw error;
        }
    }
    const deletePelicula = async (id) => {
        try {
            const response = await axios.delete(`${API_URL}/${id}`);
            return response.data;
        } catch (error) {
            throw error;
        }
    }

 //director, fechaInicio, fechaFin, genero -

  async function obtenerPeliculasFiltradas(query) {
    try {
        const response = await axios.post(`${API_URL}/query`, query);
        return response.data.data;
    } catch (error) {
        throw error;
    }
}


export  {
   obtenerPeliculas,
    savePelicula,
    updatePelicula,
    deletePelicula,
    obtenerPeliculasFiltradas
};