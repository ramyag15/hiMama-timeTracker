import axios from 'axios';  

//Step 1
export const FETCH_EVENTS = 'fetch_events';
export const FETCH_EVENT = 'fetch_event';
export const CREATE_EVENT = 'create_event';
export const DELETE_EVENT = 'delete_event';
export const ROOT_URL = 'http://localhost:8080';

export function fetchUserEvents() {
    const request = axios.get(`${ROOT_URL}/user_events`);

    return {
        type: FETCH_EVENTS,
        payload: request
    };
}

export function createUserEvent(values, callback) {
    const request = axios.post(`${ROOT_URL}/new_user_event`, values)
        .then(() => callback());

    return {
        type: CREATE_EVENT,
        payload: request
    };
}

export function fetchUserEvent(id) {
    const request = axios.get(`${ROOT_URL}/user_event/${id}`);

    return {
        type: FETCH_EVENT,
        payload: request
    };
}

export function deleteUserEvent(id, callback) {
    const request = axios.delete(`${ROOT_URL}/user_event/${id}`)
        .then(() => callback());

    return {
        type: DELETE_EVENT,
        payload: id
    };
}