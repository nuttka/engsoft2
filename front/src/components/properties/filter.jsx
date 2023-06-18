import { Card, Typography, CssBaseline, Button, FormControl, InputLabel, Select, MenuItem, Container } from "@material-ui/core";
import React, {useState} from "react";
import useStyles from "./styles";

const Filter = () => {
    const [tipoImovel, setTipoImovel] = useState('');
    const [isComercial, setIsComercial] = useState('');
    const classes = useStyles;

    const [imoveis, setImoveis] = useState([])


    const getImoveis = async () => {
        await fetch(`http://localhost:8080/property`, {
            method: 'GET',
        }).then((response) => {
            if (response.status === 200) {
                response.json().then(json => {

                    setImoveis(json);
                    console.log(json);
                })

            } else {
                return;
            }
        });
    };

    return (
        <Container style={{display:'flex', alignItems:'center', marginBottom:'50px'}}>
            <CssBaseline/>
            <div style={{ display:'flex', flexDirection:'row', width:'55rem', alignItems:'center'}}>
                <InputLabel id="tipoImovel" style={{ marginLeft: '10px', marginRight: '10px' }}>Tipo do imóvel
                </InputLabel>
                <Select style={{marginTop:'10px', width:'150px'}}
                labelId="tipoImovel" id="imovel" value={tipoImovel} label="Tipo do imóvel" onChange={(value) => setTipoImovel(value.target.value)}
                >
                    <MenuItem value="apartamento">Apartamento</MenuItem>
                    <MenuItem value="casa">Casa</MenuItem>
                </Select>

                <InputLabel id="isComercial" style={{ marginLeft: '10px', marginRight: '10px' }}>É comercial?
                </InputLabel>
                <Select style={{marginTop:'10px', width:'150px'}}
                labelId="isComercial" id="comercial" value={isComercial} label="É comercial?" onChange={(value) => setIsComercial(value.target.value)}
                >
                    <MenuItem value="1">Sim</MenuItem>
                    <MenuItem value="0">Não</MenuItem>
                </Select>

                <Button value="Filtrar" style={{ marginLeft: '10px', marginRight: '10px' }} onClick={() => getImoveis()} >Filtrar</Button>
                {/*<ol>{*/}
                {/*    imoveis.map((imovel) => (*/}
                {/*        <div>*/}
                {/*        <img src={imovel.imageUrl} alt=""/>*/}
                {/*        <li>{imovel.id}</li>*/}
                {/*        </div>*/}
                {/*    ))}*/}
                {/*</ol>*/}

            </div>
        </Container>

    );
}

export default Filter;