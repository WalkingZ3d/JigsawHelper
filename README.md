# JigsawHelper

## Project Description
Jigsaw Helper is an application that assist users with a jigsaw puzzle. This is achieved by comparing the pixles of each image (piece against final completed image from the box) generated and populated into arrays.

An edge detector (Sobel) is used to determine if the piece has an edge, as this can reduce the serach necesary.

If an edge is detected, the applicaiton uses a greyscle 2d array of pixels.

If no edge is detected, the application uses a 3d array of pixels (r, g, g).

The two arrays (piece and final image) are then compared. This is achieved by taking a comparator cut from the final image into an array the same size of the image array. A comparator cut is used for the whole final image. 

Mean squared error is then used to determine the likeleness of a match between comparator array and piece array.

The user can then see the result of the prediction on the GUI.
