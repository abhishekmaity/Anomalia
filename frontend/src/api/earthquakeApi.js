import api from './axiosConfig';

export const fetchRecentEarthquakes = async (page = 0, size = 10) => {
  const response = await api.get(`/earthquakes/recent?page=${page}&size=${size}`);
  return response.data;
};
