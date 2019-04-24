import _ from 'lodash';
import { FETCH_EVENTS, FETCH_EVENT , DELETE_EVENT } from '../actions';


export default function(state = {}, action) {
    switch(action.type) {
        case FETCH_EVENTS:
            return _.mapKeys(action.payload.data, 'userEventId');
        case FETCH_EVENT:
            // const post = action.payload.data;
            // const newState = { ...state };
            // newState[post.id] = post;
            // return newState; -- old ES5 way

            // New ES6 key interpolation way -- fancy stuff
            return { ...state, [action.payload.userEventId]: action.payload.data };
        case DELETE_EVENT:
            return _.omit(state, action.payload);
        default:
            return state;
    }
}
