import api from './axiosConfig';

export const fetchRecentEpidemics = async (page = 0, size = 10) => {
  const response = await api.get(`/epidemics/recent?page=${page}&size=${size}`);
  return response.data;
};
