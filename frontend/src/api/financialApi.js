import api from './axiosConfig';

export const fetchRecentFinancialData = async (page = 0, size = 10) => {
  const response = await api.get(`/financial/recent?page=${page}&size=${size}`);
  return response.data;
};
