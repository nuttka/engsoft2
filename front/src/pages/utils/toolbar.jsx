import React from 'react';
import { Typography, AppBar, CssBaseline, Toolbar, Button, Link  } from '@material-ui/core';
import HomeIcon from '@mui/icons-material/Home';
import useStyles from '../../components/properties/styles';
import { Link as routerLink } from 'react-router-dom';


const NavigationBar = () => {
    const classes = useStyles();

    return (
        <>
            <CssBaseline />
            <AppBar position="relative">
                <Toolbar>
                    <Link color="inherit" href="/">
                        <HomeIcon />
                    </Link>
                    <div className={classes.titleDisplay}>
                        <Typography align="left">
                            Imobiliária Digital
                        </Typography>
                    </div>
                    <div className={classes.buttonDisplay}>
                        <Button component={routerLink} to="/register" color="inherit" variant="outlined">Cadastrar imóvel</Button>
                    </div>
                </Toolbar>
            </AppBar>
        </>
    )
}

export default NavigationBar;