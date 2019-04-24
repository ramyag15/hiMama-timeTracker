import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { createUserEvent } from '../actions';

class EventsNew extends Component {
    renderField(field) {
        const { meta: { touched, error } } = field;
        const className = `form-group ${touched && error ? 'has-danger': ''}`;

        return (
            <div className={className}>
                <label>{field.label}</label>
                <input className="form-control"
                    type="text"
                    {...field.input}
                />
                <div className="text-help">
                {touched ? error: ''}
                </div>
            </div>
        );
    }

    onSubmit(values) {
        this.props.createUserEvent(values, () => {
            this.props.history.push('/');
        });
    }         

    render() {
        const { handleSubmit } = this.props;

        return (
           <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
               <Field 
                    label="User Name"
                    name="userName"
                    component={this.renderField}
               />
               <Field name="eventType" component="select" className="form-group">
                    <option />
                    <option value="0">In Time</option>
                    <option value="1">Out Time</option>
                </Field>
                <br />
               <button type="submit" className="btn btn-primary">Submit</button>
               <Link to="/" className="btn btn-danger">Cancel</Link>
           </form>
        );
    }
}

function validate(values) {
    const errors = {};

    //validate the input from the values object
    if(!values.userName) {
        errors.userName = "Username is a required field!";
    }
    if(!values.eventType) {
        errors.eventType = "Event Type is a required field!";
    }

    return errors;
}

export default reduxForm({
    validate,
    form: 'EventsNewForm'
})(
    connect(null, { createUserEvent })(EventsNew)
);