import React, { Component } from 'react';
import Message from './Message'
class NewsFeed extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.tweets.map(({pseudo, image,date, message,id_message}) =>
					<Message pseudo={pseudo} image={image} id={id_message} date={date} message = {message} goUser={this.props.goUser} />
					
				)


			)
	}
}

export default NewsFeed;