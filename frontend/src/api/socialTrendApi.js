import api from './axiosConfig';

export const fetchRecentTrends = async (page = 0, size = 10) => {
  const response = await api.get(`/social/recent?page=${page}&size=${size}`);
  return response.data;
};
