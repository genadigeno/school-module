USE [satesto]
GO
/****** Object:  Table [dbo].[class_subjects]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[class_subjects](
	[class_id] [int] NOT NULL,
	[subject_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[classes]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[classes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[class_index] [varchar](255) NULL,
	[class_name] [varchar](255) NULL,
	[class_number] [int] NULL,
	[school_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dictionaries]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dictionaries](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[dictionary_key] [varchar](255) NULL,
	[dictionary_name] [varchar](255) NULL,
	[enabled] [bit] NULL,
	[parent_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pupils]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pupils](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[birth_date] [datetime2](7) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[first_name] [varchar](255) NOT NULL,
	[last_name] [varchar](255) NOT NULL,
	[personal_number] [varchar](11) NOT NULL,
	[class_id] [int] NULL,
	[gender] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[schools]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[schools](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[school_address] [varchar](255) NULL,
	[school_code] [varchar](255) NULL,
	[school_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject_marks]    Script Date: 2/28/2021 13:14:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject_marks](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[assign_date] [datetime2](7) NULL,
	[mark] [int] NULL,
	[pupil_id] [int] NOT NULL,
	[subject_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[classes] ON 

INSERT [dbo].[classes] ([id], [class_index], [class_name], [class_number], [school_id]) VALUES (1, N'2B', N'', 11, 1)
INSERT [dbo].[classes] ([id], [class_index], [class_name], [class_number], [school_id]) VALUES (2, N'1A', N'', 10, 1)
INSERT [dbo].[classes] ([id], [class_index], [class_name], [class_number], [school_id]) VALUES (3, N'A-1', N'', 12, 2)
SET IDENTITY_INSERT [dbo].[classes] OFF
SET IDENTITY_INSERT [dbo].[dictionaries] ON 

INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (1, N'key.gender', N'Gender', 1, NULL)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (2, N'key.subject', N'Subject', 1, NULL)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (3, N'key.gender.male', N'Male', 1, 1)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (4, N'key.gender.female', N'Female', 1, 1)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (5, N'key.subject.geography', N'Geography', 1, 2)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (6, N'key.subject.mathematics', N'Mathematics', 1, 2)
INSERT [dbo].[dictionaries] ([id], [dictionary_key], [dictionary_name], [enabled], [parent_id]) VALUES (7, N'key.subject.history', N'History', 1, 2)
SET IDENTITY_INSERT [dbo].[dictionaries] OFF
SET IDENTITY_INSERT [dbo].[pupils] ON 

INSERT [dbo].[pupils] ([id], [birth_date], [email], [first_name], [last_name], [personal_number], [class_id], [gender]) VALUES (5, CAST(N'2004-01-05T00:00:00.0000000' AS DateTime2), N'gesgg@gml.ck', N'fisrtnm1', N'lastnm', N'11111111111', 1, 3)
INSERT [dbo].[pupils] ([id], [birth_date], [email], [first_name], [last_name], [personal_number], [class_id], [gender]) VALUES (6, CAST(N'2013-06-05T00:00:00.0000000' AS DateTime2), N'gtm@gml.co', N'frst', N'lstnm', N'11111100001', 3, 3)
INSERT [dbo].[pupils] ([id], [birth_date], [email], [first_name], [last_name], [personal_number], [class_id], [gender]) VALUES (7, CAST(N'2012-01-31T00:00:00.0000000' AS DateTime2), N'genadimumladze44@gmail.com', N'fisrtnm1', N'fisrtnm1', N'00000000000', 1, 3)
SET IDENTITY_INSERT [dbo].[pupils] OFF
SET IDENTITY_INSERT [dbo].[schools] ON 

INSERT [dbo].[schools] ([id], [school_address], [school_code], [school_name]) VALUES (1, N'Addr 1', N'11', N'Public School')
INSERT [dbo].[schools] ([id], [school_address], [school_code], [school_name]) VALUES (2, N'Addr 2', N'1', N'Private School')
SET IDENTITY_INSERT [dbo].[schools] OFF
SET IDENTITY_INSERT [dbo].[subject_marks] ON 

INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (2, CAST(N'2020-02-02T00:00:00.0000000' AS DateTime2), 7, 5, 5)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (3, CAST(N'2020-02-02T00:00:00.0000000' AS DateTime2), 1, 6, 5)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (4, CAST(N'2021-02-28T00:00:00.0000000' AS DateTime2), 9, 5, 6)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (5, CAST(N'2021-02-22T00:00:00.0000000' AS DateTime2), 10, 5, 5)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (6, CAST(N'2021-02-28T00:00:00.0000000' AS DateTime2), 4, 5, 5)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (7, CAST(N'2021-02-28T00:00:00.0000000' AS DateTime2), 1, 5, 5)
INSERT [dbo].[subject_marks] ([id], [assign_date], [mark], [pupil_id], [subject_id]) VALUES (8, CAST(N'2021-02-08T00:00:00.0000000' AS DateTime2), 9, 7, 5)
SET IDENTITY_INSERT [dbo].[subject_marks] OFF
ALTER TABLE [dbo].[class_subjects]  WITH CHECK ADD  CONSTRAINT [FK9lbjv66u7pnj5dos5mr8rf210] FOREIGN KEY([subject_id])
REFERENCES [dbo].[dictionaries] ([id])
GO
ALTER TABLE [dbo].[class_subjects] CHECK CONSTRAINT [FK9lbjv66u7pnj5dos5mr8rf210]
GO
ALTER TABLE [dbo].[class_subjects]  WITH CHECK ADD  CONSTRAINT [FKqj4bwb8mpht4mqjlx321qt7i0] FOREIGN KEY([class_id])
REFERENCES [dbo].[classes] ([id])
GO
ALTER TABLE [dbo].[class_subjects] CHECK CONSTRAINT [FKqj4bwb8mpht4mqjlx321qt7i0]
GO
ALTER TABLE [dbo].[classes]  WITH CHECK ADD  CONSTRAINT [FKh0oaysw8jogs1h9q9ph5dvp5d] FOREIGN KEY([school_id])
REFERENCES [dbo].[schools] ([id])
GO
ALTER TABLE [dbo].[classes] CHECK CONSTRAINT [FKh0oaysw8jogs1h9q9ph5dvp5d]
GO
ALTER TABLE [dbo].[dictionaries]  WITH CHECK ADD  CONSTRAINT [FKca9cgm9r2guix9h28wlh1i7h2] FOREIGN KEY([parent_id])
REFERENCES [dbo].[dictionaries] ([id])
GO
ALTER TABLE [dbo].[dictionaries] CHECK CONSTRAINT [FKca9cgm9r2guix9h28wlh1i7h2]
GO
ALTER TABLE [dbo].[pupils]  WITH CHECK ADD  CONSTRAINT [FKgkbft74nq10jhb6qlwwnblw85] FOREIGN KEY([class_id])
REFERENCES [dbo].[classes] ([id])
GO
ALTER TABLE [dbo].[pupils] CHECK CONSTRAINT [FKgkbft74nq10jhb6qlwwnblw85]
GO
ALTER TABLE [dbo].[pupils]  WITH CHECK ADD  CONSTRAINT [FKtbcsqt3gppikvjp6iudw67p1d] FOREIGN KEY([gender])
REFERENCES [dbo].[dictionaries] ([id])
GO
ALTER TABLE [dbo].[pupils] CHECK CONSTRAINT [FKtbcsqt3gppikvjp6iudw67p1d]
GO
ALTER TABLE [dbo].[subject_marks]  WITH CHECK ADD  CONSTRAINT [FK2r6ngecaw2nor4pl3msskk5p9] FOREIGN KEY([subject_id])
REFERENCES [dbo].[dictionaries] ([id])
GO
ALTER TABLE [dbo].[subject_marks] CHECK CONSTRAINT [FK2r6ngecaw2nor4pl3msskk5p9]
GO
ALTER TABLE [dbo].[subject_marks]  WITH CHECK ADD  CONSTRAINT [FKj1s1m9cogm0ydca2wdj86dpmp] FOREIGN KEY([pupil_id])
REFERENCES [dbo].[pupils] ([id])
GO
ALTER TABLE [dbo].[subject_marks] CHECK CONSTRAINT [FKj1s1m9cogm0ydca2wdj86dpmp]
GO
ALTER TABLE [dbo].[subject_marks]  WITH CHECK ADD CHECK  (([mark]>=(1) AND [mark]<=(10)))
GO
