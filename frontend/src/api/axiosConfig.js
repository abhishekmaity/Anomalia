import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // adjust if backend is hosted differently
  headers: {
    'Content-Type': 'application/json'
  }
});

export default api;
