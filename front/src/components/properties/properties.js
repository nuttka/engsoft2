import { Button, Card, CardActions, CardContent, CardMedia, Container, Grid, Typography } from "@material-ui/core";
import { Component } from "react";
import PropTypes from 'prop-types';
import { withStyles } from "@mui/styles";
import { Link } from 'react-router-dom';
 
import useStyles from "./styles"
import Filter from "./filter";


const styles = theme => ({
    titleDisplay: {
        display: 'flex',
        margin: 'auto'
    },
    
    buttonDisplay: {
        display: 'flex',
        marginRight: '0px'
    },
    
    listAlign: {
        marginTop: '50px'
    },

    cardGrid: {
        padding: '20px 0 0',
        marginTop: '20px'
    },
    
    card: {
        height: '100%',
        display: 'flex',
        flexDirection: 'column'
    },
    
    cardMedia: {
        paddingTop: '56.25%' //16:9
    },
    
    cardContent: {
        flexGrow: 1
    },
});

class Properties extends Component {
    constructor() {
        super();
        this.state = {
            properties: [],
            isLoaded: false
        };
    }

    componentDidMount() {
        fetch('https://localhost:7126/api/v1/Property')
            .then(res => res.json())
            //.then(res => console.log(res.data))
            //.then(res => res.data.filter(obj => obj.isActive === true))
            .then(res => {
                this.setState({
                    isLoaded: true,
                    properties: res.data
                });
            })
            .then(() => console.log('Properties are loaded .. ', this.state.properties));
    }

    render() {
        const { classes } = this.props;
        return (
            <main>
                <Container className={classes.cardGrid} maxWidth="md">
                    <Filter style={{minWidth:"120px"}}/>
                    <Grid container spacing={4}>
                        {this.state.properties.map((property, index) => {
                            return (
                                <Grid item key={property} xs={12} sm={6} md={4}>
                                    <Card className={classes.card}>
                                        <CardMedia
                                            key={index}
                                            className={classes.cardMedia}
                                            image={property.imageUrl}
                                            title="random title"
                                        />
                                        <CardContent className={classes.cardContent}>
                                            <Typography variant="h5">
                                                {property.name}
                                            </Typography>
                                            <Typography variant="p">
                                                <p>{property.description}</p>
                                            </Typography>
                                            <Typography variant="p">
                                                <p>{property.address}</p>
                                            </Typography>
                                        </CardContent>
                                        <CardActions>
                                            <Link to={`/property/${property.id}`}> 
                                                <Button size="small" color="primary">
                                                    Visualizar
                                                </Button>
                                            </Link>
                                        </CardActions>
                                    </Card>
                                </Grid>
                            )
                        })}
                    </Grid>
                </Container>
            </main>
        )
    }
}

Properties.propTypes = {
    classes: PropTypes.object.isRequired,
};
  
export default withStyles(styles)(Properties);