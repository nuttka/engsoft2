import { makeStyles } from '@material-ui/styles';

const useStyles = makeStyles((theme) => ({
    titleDisplay: {
        display: 'flex',
        marginRight: 'auto',
        marginLeft: '15px'
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

    footerContent: {
        display: 'flex',
        margin: 'auto'
    }
}));

export default useStyles;