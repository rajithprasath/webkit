import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Grid from '@mui/material/Grid2';
import ArrowForwardIosIcon from '@mui/icons-material/ArrowForwardIos';
import Alert from '@mui/material/Alert';
import Stack from '@mui/material/Stack';

const ReviewAndConfirm = () => {
  return (
    <>
      <Card sx={{ minWidth: 275 }}>
        <CardContent>
          <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
            Fund Name
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
        </CardContent>
      </Card>
      <div style={{ marginLeft: '16px', marginRight: '16px', marginTop: '16px' }}>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          View fund information, performance, fees and everything you need to know about this fund.
        </Typography>
        <Grid container spacing={2}>
          <Grid size={6}>
            <Typography variant="h6" component="div">
              Important notices & disclaimers
            </Typography>
          </Grid>
          <Grid size={6}>
            <ArrowForwardIosIcon />
          </Grid>
          <Grid size={6}>
            <Typography variant="h6" component="div">
              Find Documents
            </Typography>
          </Grid>
          <Grid size={6}>
            <ArrowForwardIosIcon />
          </Grid>
        </Grid>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          Before you swipe to confirm:
        </Typography>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          You are responsible for your own investment decision
        </Typography>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.
        </Typography>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
        </Typography>
        <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 12 }}>
          It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.
        </Typography>
        <Stack sx={{ width: '100%' }} spacing={2}>
          <Alert severity="warning">You cannot cancel after confirming your transactions.</Alert>
        </Stack>
      </div>
    </>
  );
}

export default ReviewAndConfirm;
