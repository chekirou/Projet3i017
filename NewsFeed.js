import React, { Component } from 'react';
import Message from './Message'
import image from './profil_homme.png'
class NewsFeed extends Component {
  	constructor(props)
  	{
  		super(props);
  	}
	render()
	{
		return (
			
				this.props.tweets.map(({pseudo,date, message,id_message}) =>
					
					<Message pseudo={pseudo} image={image} id={id_message} date={date} message = {message} goUser={this.props.goUser} delete={this.props.delete} />
					
				)


			)
	}
}

export default NewsFeed;