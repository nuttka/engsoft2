import React from 'react';
import { Typography, AppBar, CssBaseline, Toolbar  } from '@material-ui/core';
import useStyles from './styles';


const Footer = () => {
    const classes = useStyles();

    return (
        <>
            <CssBaseline />
            <AppBar position="relative" style={{ marginTop:'50px' }}>
                <Toolbar>
                    <div className={classes.footerContent}>
                        <Typography align="center">
                            @Engsoft
                        </Typography>
                    </div>
                </Toolbar>
            </AppBar>
        </>
    )
}

export default Footer;