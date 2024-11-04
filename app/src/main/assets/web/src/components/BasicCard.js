import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Grid from '@mui/material/Grid2';

const BasicCard = () => {
  return (
    <>
        <Card sx={{ minWidth: 275 }}>
        <CardContent>
            <Grid container spacing={2}>
                <Grid container justifyContent="flex-end" size={12}>
                    <div>1 min ago</div>
                </Grid>
                <Grid sx={{ justifyContent: 'flex-end' }} size={6}>
                    <div>TEMENOS AG</div>
                    <div>Share SWX:TEMN</div>
                    <div>CH0012453913</div>
                    <div>Portfolio 88001.01</div>
                    <div>Online order</div>
                </Grid>
                <Grid size={6}>
                    <div>SELL FILLED</div>
                    <div>5,000 / 5,000</div>
                    <div>Price CHF 63.53</div>
                    <div>CHF 317,650.00</div>
                    <div>SGD 480,000.00</div>
                </Grid>
            </Grid>
        </CardContent>
        </Card>
        <Card sx={{ minWidth: 275 }}>
        <CardContent>
            <Grid container spacing={2}>
                <Grid container justifyContent="flex-end" size={12}>
                    <div>1 min ago</div>
                </Grid>
                <Grid sx={{ justifyContent: 'flex-end' }} size={6}>
                    <div>TEMENOS AG</div>
                    <div>Share SWX:TEMN</div>
                    <div>CH0012453913</div>
                    <div>Portfolio 88001.01</div>
                    <div>Online order</div>
                </Grid>
                <Grid size={6}>
                    <div>SELL FILLED</div>
                    <div>5,000 / 5,000</div>
                    <div>Price CHF 63.53</div>
                    <div>CHF 317,650.00</div>
                    <div>SGD 480,000.00</div>
                </Grid>
            </Grid>
        </CardContent>
        </Card>
        <Card sx={{ minWidth: 275 }}>
        <CardContent>
            <Grid container spacing={2}>
                <Grid container justifyContent="flex-end" size={12}>
                    <div>1 min ago</div>
                </Grid>
                <Grid sx={{ justifyContent: 'flex-end' }} size={6}>
                    <div>TEMENOS AG</div>
                    <div>Share SWX:TEMN</div>
                    <div>CH0012453913</div>
                    <div>Portfolio 88001.01</div>
                    <div>Online order</div>
                </Grid>
                <Grid size={6}>
                    <div>SELL FILLED</div>
                    <div>5,000 / 5,000</div>
                    <div>Price CHF 63.53</div>
                    <div>CHF 317,650.00</div>
                    <div>SGD 480,000.00</div>
                </Grid>
            </Grid>
        </CardContent>
        </Card>
    </>
  );
}

export default BasicCard;
