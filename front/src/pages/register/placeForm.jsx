import { AppBar, Button, CssBaseline, FormControl, Input, InputLabel, Link, Select, Toolbar, Typography,
MenuItem, 
Container} from "@material-ui/core";
import React, {useState} from "react";
import HomeIcon from '@mui/icons-material/Home';
import { Link as routerLink } from 'react-router-dom';
import useStyles from '../../components/properties/styles';
import NavigationBar from "../utils/toolbar";
import Footer from "../utils/footer";

const PlaceForm = () => {
    const [tipoImovel, setTipoImovel] = useState('apartamento');
    const [nrQuartos, setNrQuartos] = useState('1');
    const [localizacao, setLocalizacao] = useState('');
    const [nrVagas, setNrVagas] = useState('');
    const [isComercial, setIsComercial] = useState('1');
    const [contato, setContato] = useState('');
    const classes = useStyles();

    return(
        <div>
            <CssBaseline/>
            <NavigationBar/>

            <Container maxWidth='sm' style={{ marginTop:'100px', marginBottom:'50px' }}>
                <Typography variant='h2' align='center' color='textPrimary' gutterBottom>
                    Cadastre seu imóvel
                </Typography>
                <Typography variant='h5' align='center' color='textSecondary' paragraph>
                    Preencha os campos para que seu imóvel apareça em nossa lista de imóveis
                </Typography>
            </Container>
            {/* <div style={{display:"flex", marginTop:"30px", justifyContent:"center"}}> */}
            <Container maxWidth='sm' style={{ marginTop:'100px', marginBottom:'50px', alignItems:"center" }}>
                <form>
                    <InputLabel id="tipoImovel">Tipo do imóvel</InputLabel>
                    <Select  style={{margin:'10px'}}
                    labelId="tipoImovel" id="imovel" value={tipoImovel} label="Tipo do imóvel" onChange={(value) => setTipoImovel(value.target.value)}
                    >
                        <MenuItem value="apartamento">Apartamento</MenuItem>
                        <MenuItem value="casa">Casa</MenuItem>
                    </Select>

                    <InputLabel variant="contained" id="nrQuartos">Quantidade de quartos</InputLabel>
                        <Input id="nrQuartos" defaultValue="1" inputProps={nrQuartos}/>

                    <InputLabel id="localizacao">Localização</InputLabel>
                    <Input id="localizacao"inputProps={localizacao}/>   

                    <InputLabel  id="nrVagas">Número de vagas na garagem</InputLabel>
                    <Input type="number" id="nrVagas" inputProps={nrVagas}/>

                    <InputLabel  id="isComercial">É comercial?</InputLabel>
                    <Select
                        labelId="isComercial" id="comercial" value={isComercial} label="É comercial?" onChange={(value) => setIsComercial(value.target.value)}
                    >
                    <MenuItem value="1">Sim</MenuItem>
                    <MenuItem value="0">Não</MenuItem>
                    </Select>

                    <InputLabel id="contato">Contato do vendedor:</InputLabel>
                    <Input id="contato" inputProps={contato} placeholder="(xx)xxxxx-xxxx"/>

                    <InputLabel id="image">Imagens</InputLabel>
                    <Input accept="image/*" id="image" multiple type="file"/>
                    <Button variant="contained" component="span">Upload</Button>

                    <Button style={{marginTop:"10rem", width:"auto"}} variant="contained" onClick={() => {}}>Cadastrar</Button>
                </form>
            </Container>
            
            {/* </div> */}
            <Footer/>
        </div>
        )}

export default PlaceForm;