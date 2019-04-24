import _ from 'lodash';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchUserEvents, deleteUserEvent } from '../actions';
import { Link } from 'react-router-dom';

class EventsIndex extends Component {
    //lifecycle process --below
    componentDidMount() {
        this.props.fetchUserEvents();
    }

    onDeleteClick(id) {
        this.props.deleteUserEvent(id, () => {
            this.props.history.push('/');
            this.props.fetchUserEvents();
        });
    }

    renderEvents() {
        return _.map(this.props.events, event => {
            return (
                <li className="list-group-item" key={event.userEventId}>
                    <div className="container">
                        <div className="row">
                            <div className="col-sm">
                                <b>User: </b> {event.userName}
                            </div>
                            <div className="col-sm">
                                <b>Event Type: </b> {event.eventType}
                            </div>
                            <div className="col-sm">
                                <b>Time: </b>{event.eventTime}
                            </div>
                            <div className="col-sm">
                            <button className="btn btn-danger pull-xs-right" 
                                onClick={this.onDeleteClick.bind(this, event.userEventId)}
                                >
                                Delete User Event
                            </button>
                                {/* <Link to={`/events/${event.userEventId}`}>Delete</Link> */}
                            </div>
                        </div>
                    </div>                    
                </li>
            );
        });
    }

    render() {
        return (
            <div>
                <div className="text-xs-right">
                <Link className="btn btn-primary" to="/events/new">
                    Add a Clock Event
                </Link>
            </div>
            <h3>Time Log</h3>
            <ul className="list-group">
                {this.renderEvents()}
            </ul>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        events: state.events.undefined
     };
}

// The line below is completely identical to mapDispatchToPosts format
export default connect(mapStateToProps, { fetchUserEvents, deleteUserEvent })(EventsIndex);