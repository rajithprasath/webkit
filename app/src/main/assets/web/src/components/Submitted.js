import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid2';
import AddTaskIcon from '@mui/icons-material/AddTask';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';
import CalendarTodayIcon from '@mui/icons-material/CalendarToday';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import Button from '@mui/material/Button';

const Submitted = () => {
  return (
    <>
        <Typography gutterBottom sx={{ color: 'text.primary', fontSize: 24, m: 2 }}>
            <AddTaskIcon /> Fund Name
        </Typography>
        <Stack sx={{ width: '100%' }} spacing={2}>
            <Alert severity="info">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</Alert>
        </Stack>
        <Card sx={{ minWidth: 275 }}>
            <CardContent>
                <Grid container spacing={2}>
                    <Grid size={6}>
                        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                            Ref no.
                        </Typography>
                    </Grid>
                    <Grid size={6}>
                        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                            1234567890
                        </Typography>
                    </Grid>
                </Grid>
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                    Portfolio Name
                </Typography>
                <Typography variant="h6" component="div">
                    United Income Fund
                </Typography>
                <hr />
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                    Total Amount
                </Typography>
                <Typography variant="h6" component="div">
                    SGD 100,000.00
                </Typography>
                <hr />
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                    Amount to Invest
                </Typography>
                <Typography variant="h6" component="div">
                    SGD 100,000.00
                </Typography>
                <hr />
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                    Pay From
                </Typography>
                <Typography variant="h6" component="div">
                    ABC One Account
                </Typography>
                <hr />
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
                    Dividend Instructions
                </Typography>
                <Typography variant="h6" component="div">
                    Reinvest
                </Typography>
                <hr />
                <Typography variant="h6" component="div">
                    <CalendarTodayIcon /> 11 Jun 2024
                </Typography>
                <hr />
                <Typography variant="h6" component="div">
                    <AccessTimeIcon /> 11:59 PM
                </Typography>
            </CardContent>
        </Card>
        <Grid container spacing={2}>
            <Grid size={2}></Grid>
            <Grid style={{marginTop: '16px'}} size={8}>
                <Button variant="contained">
                    View Transactions
                </Button>
            </Grid>
            <Grid size={2}></Grid>
            <Grid size={2}></Grid>
            <Grid size={8}>
                <Button variant="outlined">
                    Back to Invest
                </Button>
            </Grid>
            <Grid size={2}></Grid>
        </Grid>
    </>
  );
}

export default Submitted;
