import api from './axiosConfig';

export const fetchRecentWeather = async (page = 0, size = 10) => {
  const response = await api.get(`/weather/recent?page=${page}&size=${size}`);
  return response.data;
};
