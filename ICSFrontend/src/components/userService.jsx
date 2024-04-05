import api from './api';

export const getUsers = async () => {
    try {
        const response = await api.get(`/user`);
        console.log(response.data)
        return response.data;
    } catch (error) {
        console.log(error)
        throw error;
    }
}

export const createUser = async (user) => {
    try {
        const response = await api.post(`/user`,user);
        console.log(response.data)
        return response.data;
    } catch (error) {
        console.log(error)
        throw error;
    }


};