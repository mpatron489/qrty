import React from 'react';
import axios, { AxiosHeaders } from 'axios'
class QRRequestForm extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            selectedImageType: 'SVG',
            url: '',
            imageOutPut: null};
    };

    
    handleSubmit = (e) => {
        try{
            fetch('http://localhost:8080/getQRCode?imageType=' + 
            this.state.selectedImageType + 
            '&url=' + this.state.url, {
                mode: 'cors',
                method: 'get'
            })
            .then(response => {
                console.log(response.text)
            }).catch(error => {
                console.log(error)
            });

        }
        catch (error){
            console.log(error);
        }
        e.preventDefault(); 
    }

    render(){
        const formWrapperStyle = {
            display: "flex",
            flexDirection: "column",
            maxWidth: "15%",
            margin: "10px"
        }
        const labelItemStyle = {
            margin: "12px"
        }

        var imageTypeChoices = [
            {value: 'SVG',  label: 'SVG'},
            {value: 'PNG',  label: 'PNG'},
            {value: 'JPEG', label: 'JPEG'}
        ];
        return <div id="formWrapper" style={formWrapperStyle}>
            <form style={labelItemStyle} onSubmit={this.handleSubmit}>            
                <label>
                URL:  
                    <input 
                    type="text" 
                    name="name" 
                    style={labelItemStyle} 
                    onChange={(e) => this.setState({url: e.target.value})}/>
                </label>
                <label style={labelItemStyle}>
                    Image Type:
                </label>
                <select 
                    name="imageTypes" 
                    id="imageTypeSelector" 
                    value={this.state.selectedImageType}
                    onChange={(e) => this.setState({selectedImageType: e.target.value})}
                >
                    <option value='SVG'>SVG</option>
                    <option value='PNG'>PNG</option>
                    <option value='JPEG'>JPEG</option>
               </select>
                <input type="submit" value="Submit"/>
           </form>
        </div>
    }
}

export default QRRequestForm;